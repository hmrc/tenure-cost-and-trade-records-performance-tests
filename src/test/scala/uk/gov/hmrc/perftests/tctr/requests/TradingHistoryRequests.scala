/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.perftests.tctr.requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.HttpConfiguration
import uk.gov.hmrc.perftests.tctr.config.servicesConfig
import uk.gov.hmrc.perftests.tctr.requests.tctrRequests._
import utils.DateUtils._

object TradingHistoryRequests extends HttpConfiguration with servicesConfig {

  val getAboutYourTradingHistory: HttpRequestBuilder =
    http("[GET] get about your trading history page")
      .get(s"$baseUrl/$route/about-your-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAboutYourTradingHistory: HttpRequestBuilder =
    http("[POST] post about your trading history page")
      .post(s"$baseUrl/$route/about-your-trading-history")
      .formParam("firstOccupy.month", pastMonth.getMonthValue.toString)
      .formParam("firstOccupy.year", today.getYear.toString)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFinancialYearEnd: HttpRequestBuilder =
    http("[GET] get financial year end page")
      .get(s"$baseUrl/$route/financial-year-end")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFinancialYearEnd: HttpRequestBuilder =
    http("[POST] post financial year end page")
      .post(s"$baseUrl/$route/financial-year-end")
      .formParam("financialYear.day", today.day)
      .formParam("financialYear.month", today.month)
      .formParam("yearEndChanged", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFinancialYearEndDates: HttpRequestBuilder =
    http("[GET] get financial year end dates page")
      .get(s"$baseUrl/$route/financial-year-end-dates")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFinancialYearEndDates: HttpRequestBuilder =
    http("[POST] post financial year end dates page")
      .post(s"$baseUrl/$route/financial-year-end-dates")
      .formParamMap(Map(
        "financial-year-end[0].date.day" -> today.day,
        "financial-year-end[0].date.month" -> today.month,
        "financial-year-end[0].date.year" -> today.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))


  val getTurnOverPage: HttpRequestBuilder =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTurnOver(AlcoholDrinks: Int, Food: Int, otherReceipts: Int, accommodation: Int, averageOccupancyRate: Int): HttpRequestBuilder =
    http("[POST] post turnover page")
      .post(s"$baseUrl/$route/turnover")
      .formParamMap(Map(
        "0.weeks" -> "52",
        "0.alcoholic-drinks" -> AlcoholDrinks,
        "0.food" -> Food,
        "0.other-receipts" -> otherReceipts,
        "0.accommodation" -> accommodation,
        "0.average-occupancy-rate" -> averageOccupancyRate,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  val getCostOfSales: HttpRequestBuilder =
    http("[GET] get cost of sales page")
      .get(s"$baseUrl/$route/cost-of-sales")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCostOfSales(accommodation: String, food: String, drinks: String, other: String): HttpRequestBuilder =
    http("[POST] post cost of sales page")
      .post(s"$baseUrl/$route/cost-of-sales")
      .formParamMap(Map(
        "costOfSales[0].accommodation" -> accommodation,
        "costOfSales[0].food" -> food,
        "costOfSales[0].drinks" -> drinks,
        "costOfSales[0].other" -> other,
        "csrfToken" -> f"$${csrfToken}"))
        .check(status.is(303))

  val getTotalPayrollCosts: HttpRequestBuilder =
    http("[GET] get total payroll costs page")
      .get(s"$baseUrl/$route/total-payroll-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTotalPayrollCosts(managerAndStaff: String, remuneration:String): HttpRequestBuilder =
    http("[POST] POST total payroll costs page")
      .post(s"$baseUrl/$route/total-payroll-costs")
      .formParamMap(Map(
        "totalPayrollCosts[0].managers-and-staff" -> managerAndStaff,
        "totalPayrollCosts[0].directors-remuneration" -> remuneration,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  val getVariableOperatingExpenses: HttpRequestBuilder =
    http("[GET] get Variable Operating Expenses page")
      .get(s"$baseUrl/$route/variable-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postVariableOperatingExpenses(energyAndUtilities: String, cleaningAndLaundry: String, buildingMaintenanceAndRepairs: String, fixturesFittingsAndEquipment:String, advertisingAndPromotions:String, administrationAndSundries:String, entertainment: String, other: String, otherExpensesDetails: String ): HttpRequestBuilder =
    http("[POST] post Variable Operating Expenses page")
      .post(s"$baseUrl/$route/variable-operating-expenses")
      .formParamMap(Map(
        "variableOperatingExpenses.year[0].energy-and-utilities" -> energyAndUtilities,
        "variableOperatingExpenses.year[0].cleaning-and-laundry" -> cleaningAndLaundry,
        "variableOperatingExpenses.year[0].building-maintenance-and-repairs" -> buildingMaintenanceAndRepairs,
        "variableOperatingExpenses.year[0].fixtures-fittings-and-equipment" -> fixturesFittingsAndEquipment,
        "variableOperatingExpenses.year[0].advertising-and-promotions" -> advertisingAndPromotions,
        "variableOperatingExpenses.year[0].administration-and-sundries" -> administrationAndSundries,
        "variableOperatingExpenses.year[0].entertainment" -> entertainment,
        "variableOperatingExpenses.year[0].other" -> other,
        "otherExpensesDetails" -> otherExpensesDetails,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  val getFixedOperatingExpenses: HttpRequestBuilder =
    http("[GET] get Fixed Operating Expenses page")
      .get(s"$baseUrl/$route/fixed-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFixedOperatingExpenses(rent: String, businessRates:String, insurance: String, loanInterest: String, depreciation: String ): HttpRequestBuilder =
    http("[POST] post Fixed Operating Expenses page")
      .post(s"$baseUrl/$route/fixed-operating-expenses")
      .formParamMap(Map(
        "fixedOperatingExpenses[0].rent" -> rent,
        "fixedOperatingExpenses[0].business-rates" -> businessRates,
        "fixedOperatingExpenses[0].insurance" -> insurance,
        "fixedOperatingExpenses[0].loan-interest" -> loanInterest,
        "fixedOperatingExpenses[0].depreciation" -> depreciation,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  val getOtherCosts: HttpRequestBuilder =
    http("[GET] get other costs page")
      .get(s"$baseUrl/$route/other-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postOtherCosts(contributionsToHeadOffice: String, otherCosts: String, otherCostsDetails: String): HttpRequestBuilder =
    http("[POST] post other costs page")
      .post(s"$baseUrl/$route/other-costs")
      .formParamMap(Map(
        "otherCosts[0].contributionsToHeadOffice" -> contributionsToHeadOffice,
        "otherCosts[0].otherCosts" -> otherCosts,
        "otherCostDetails" -> otherCostsDetails,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  val getIncomeExpenditureSummary: HttpRequestBuilder =
    http("[GET] get income expenditure summary page")
      .get(s"$baseUrl/$route/income-expenditure-summary")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIncomeExpenditureSummary(option: String): HttpRequestBuilder =
    http("[POST] post income expenditure summary page")
      .post(s"$baseUrl/$route/income-expenditure-summary")
      .formParam("incomeExpenditureSummary", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getUnusualCircumstances: HttpRequestBuilder =
    http("[GET] get unusual circumstances page")
      .get(s"$baseUrl/$route/unusual-circumstances")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postUnusualCircumstances(details: String): HttpRequestBuilder =
    http("[POST] post unusual circumstances page")
      .post(s"$baseUrl/$route/unusual-circumstances")
      .formParam("unusualCircumstances", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getCYAAboutTradingHistory: HttpRequestBuilder =
    http("[GET] get cya about your trading history")
      .get(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAAboutTradingHistory(option: String): HttpRequestBuilder =
    http("[POST] post cya about your trading history")
      .post(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .formParam("checkYourAnswersAboutTheTradingHistory", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val TradingHistorySection: Seq[HttpRequestBuilder] = Seq(
    getTaskListPage,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )

  val TradingHistorySectionFor6015: Seq[HttpRequestBuilder] = Seq(
    getTaskListPage,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCostOfSales,
    postCostOfSales("110", "11", "23", "24"),
    getTotalPayrollCosts,
    postTotalPayrollCosts("33", "10"),
    getVariableOperatingExpenses,
    postVariableOperatingExpenses("11", "23", "345", "123", "34", "0", "0", "23", "other expense details"),
    getFixedOperatingExpenses,
    postFixedOperatingExpenses("2300", "0", "50", "11", "23"),
    getOtherCosts,
    postOtherCosts("124", "400", "other details"),
    getIncomeExpenditureSummary,
    postIncomeExpenditureSummary("confirmed"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )

  val TradingHistorySectionFor6016: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
}

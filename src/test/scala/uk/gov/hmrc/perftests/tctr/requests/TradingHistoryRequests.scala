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

  val getWhatYouWillNeed: HttpRequestBuilder =
    http("[GET] get what you will need page")
      .get(s"$baseUrl/$route/what-you-will-need")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

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

  val getFinancialYearEndDatesSummary: HttpRequestBuilder =
    http("[GET] get financial year end dates summary page")
      .get(s"$baseUrl/$route/financial-year-end-dates-summary")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getElectricityGenerated: HttpRequestBuilder =
    http("[GET] get electricity generated page")
      .get(s"$baseUrl/$route/electricity-generated")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getGrossReceiptsExcludingVat: HttpRequestBuilder =
    http("[GET] get gross receipts excluding VAT receipts page")
      .get(s"$baseUrl/$route/gross-receipts-excluding-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postGrossReceiptsExcludingVat: HttpRequestBuilder =
    http("[POST] post gross receipts excluding VAT receipts page")
      .post(s"$baseUrl/$route/gross-receipts-excluding-vat")
      .formParamMap(Map(
        "grossReceiptsExcludingVAT[0].electricitySales" -> "123",
        "grossReceiptsExcludingVAT[0].feedInTariff" -> "123",
        "grossReceiptsExcludingVAT[0].rocBuyout" -> "123",
        "grossReceiptsExcludingVAT[0].rocRecycle" -> "123",
        "grossReceiptsExcludingVAT[0].contractForDifference" -> "123",
        "grossReceiptsExcludingVAT[0].capacityMarket" -> "123",
        "grossReceiptsExcludingVAT[0].balancingServices" -> "123",
        "grossReceiptsExcludingVAT[0].embeddedBenefits" -> "123",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getOtherIncome: HttpRequestBuilder =
    http("[GET] get other income page")
      .get(s"$baseUrl/$route/other-income")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postOtherIncome: HttpRequestBuilder =
    http("[POST] get other income page")
      .post(s"$baseUrl/$route/other-income")
      .formParamMap(Map(
        "otherIncomeSeq.turnover[0].otherIncome" -> "124",
        "otherIncomeDetails" -> "details",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCostOfSalesIntermittent: HttpRequestBuilder =
    http("[GET] get cost of sales intermittent page")
      .get(s"$baseUrl/$route/cost-of-sales-intermittent-6076")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCostOfSalesIntermittent: HttpRequestBuilder =
    http("[POST] post cost of sales intermittent page")
      .post(s"$baseUrl/$route/cost-of-sales-intermittent-6076")
      .formParamMap(Map(
        "costOfSales6076.[0].importedPower" -> "234",
        "costOfSales6076.[0].TNuoS" -> "345",
        "costOfSales6076.[0].BSuoS" -> "456",
        "costOfSales6076.[0].otherSales" -> "432",
        "otherSalesDetails" -> "details",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getStaffCosts: HttpRequestBuilder =
    http("[GET] get staff costs page")
      .get(s"$baseUrl/$route/staff-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postStaffCosts: HttpRequestBuilder =
    http("[POST] post staff costs page")
      .post(s"$baseUrl/$route/staff-costs")
      .formParamMap(Map(
        "staffCosts.[0].wages" -> "123",
        "staffCosts.[0].NI" -> "234",
        "staffCosts.[0].pension" -> "345",
        "staffCosts.[0].remunerations" -> "345",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getPremisesCosts: HttpRequestBuilder =
    http("[GET] get premises costs page")
      .get(s"$baseUrl/$route/premises-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPremiseCosts: HttpRequestBuilder =
    http("[POST] post premises costs page")
      .post(s"$baseUrl/$route/premises-costs")
      .formParamMap(Map(
        "premisesCosts.[0].energyAndUtilities" -> "123",
        "premisesCosts.[0].buildingRepairAndMaintenance" -> "234",
        "premisesCosts.[0].repairsAndRenewalsOfFixtures" -> "456",
        "premisesCosts.[0].rent" -> "678",
        "premisesCosts.[0].businessRates" -> "789",
        "premisesCosts.[0].buildingInsurance" -> "5678",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getOperationalExpenses: HttpRequestBuilder =
    http("[GET] get operational expenses")
      .get(s"$baseUrl/$route/operational-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postOperationalExpenses: HttpRequestBuilder =
    http("[POST] post operational expenses")
      .post(s"$baseUrl/$route/operational-expenses")
      .formParamMap(Map(
        "operationalExpensesSeq.turnover[0].advertising" -> "123",
        "operationalExpensesSeq.turnover[0].administration" -> "456",
        "operationalExpensesSeq.turnover[0].insurance" -> "567",
        "operationalExpensesSeq.turnover[0].legalFees" -> "679",
        "operationalExpensesSeq.turnover[0].interest" -> "5678",
        "operationalExpensesSeq.turnover[0].other" -> "567",
        "otherExpensesDetails" -> "456",
        "csrfToken" -> f"$${csrfToken}"
      ))
   .check(status.is(303))

  val getHeadOfficeExpenses: HttpRequestBuilder =
    http("[GET] get head office expenses page")
      .get(s"$baseUrl/$route/head-office-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postHeadOfficeExpenses: HttpRequestBuilder =
    http("[POST] post head office expenses page")
      .post(s"$baseUrl/$route/head-office-expenses")
      .formParam("headOfficeExpensesSeq.turnover[0].headOfficeExpenses", "4567")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIncomeExpenditureSummary6076: HttpRequestBuilder =
    http("[GET] get income expenditure summary for 6076 page")
      .get(s"$baseUrl/$route/income-expenditure-summary-6076")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postIncomeExpenditureSummary6076: HttpRequestBuilder =
    http("[POST] post income expenditure summary for 6076 page")
      .post(s"$baseUrl/$route/income-expenditure-summary-6076")
      .formParam("incomeExpenditureSummary6076", "confirmed")
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
      .check(headerRegex("Set-Cookie", """mdtp=(.*?);""").saveAs("mdtpCookie"))

  val getTurnOverPage: HttpRequestBuilder =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover")
      .check(status.is(200))
      .header(HttpHeaderNames.Cookie, "mdtp=${mdtpCookie}")
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTurnOver6030: HttpRequestBuilder =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover-6030")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCostOfSales: HttpRequestBuilder =
    http("[GET] get cost of sales page")
      .get(s"$baseUrl/$route/cost-of-sales")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTotalPayrollCosts: HttpRequestBuilder =
    http("[GET] get total payroll costs page")
      .get(s"$baseUrl/$route/total-payroll-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getVariableOperatingExpenses: HttpRequestBuilder =
    http("[GET] get Variable Operating Expenses page")
      .get(s"$baseUrl/$route/variable-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getFixedOperatingExpenses: HttpRequestBuilder =
    http("[GET] get Fixed Operating Expenses page")
      .get(s"$baseUrl/$route/fixed-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getOtherCosts: HttpRequestBuilder =
    http("[GET] get other costs page")
      .get(s"$baseUrl/$route/other-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getIncomeExpenditureSummary: HttpRequestBuilder =
    http("[GET] get income expenditure summary page")
      .get(s"$baseUrl/$route/income-expenditure-summary")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getUnusualCircumstances: HttpRequestBuilder =
    http("[GET] get unusual circumstances page")
      .get(s"$baseUrl/$route/unusual-circumstances")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCYAAboutTradingHistory: HttpRequestBuilder =
    http("[GET] get cya about your trading history")
      .get(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTotalFuelSold: HttpRequestBuilder =
    http("[GET] get total fuel sold page")
      .get(s"$baseUrl/$route/total-fuel-sold")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkeredFuelQuestion: HttpRequestBuilder =
    http("[GET] get bunkered fuel question page")
      .get(s"$baseUrl/$route/bunkered-fuel-question")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkeredFuelSold: HttpRequestBuilder =
    http("[GET] get bunkered fuel sold page")
      .get(s"$baseUrl/$route/bunkered-fuel-sold")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkerFuelCardsDetails: HttpRequestBuilder =
    http("[GET] get bunkered fuel card details page")
      .get(s"$baseUrl/$route/bunker-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAddAnotherBunkerFuelCardsDetails: HttpRequestBuilder =
    http("[GET] get add another bunker fuel card details page")
      .get(s"$baseUrl/$route/add-another-bunker-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCustomerCreditAccounts: HttpRequestBuilder =
    http("[GET] get customer credit accounts page")
      .get(s"$baseUrl/$route/customer-credit-accounts")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAcceptLowMarginFuelCard: HttpRequestBuilder =
    http("[GET] get Accept Low Margin Fuel Card")
      .get(s"$baseUrl/$route/accept-low-margin-fuel-card")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getPercentageFromFuelCards: HttpRequestBuilder =
    http("[GET] get percentage from fuel card page")
      .get(s"$baseUrl/$route/percentage-from-fuel-cards")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getLowMarginFuelCardsDetails: HttpRequestBuilder =
    http("[GET] get low margin fuel cards details page")
      .get(s"$baseUrl/$route/low-margin-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAddAnotherLowMarginFuelCardDetails: HttpRequestBuilder =
    http("[GET] get add another low margin fuel cards details page")
      .get(s"$baseUrl/$route/add-another-low-margin-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getNonFuelTurnOver: HttpRequestBuilder =
    http("[GET] get non fuel turn over page")
      .get(s"$baseUrl/$route/non-fuel-turnover")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getElectricVehicleChargingPoints: HttpRequestBuilder =
    http("[GET] get electric vehicle charging points page")
      .get(s"$baseUrl/$route/electric-vehicle-charging-points")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
  def postWhatYouWillNeed: HttpRequestBuilder =
    http("[POST] post what you will need page")
      .post(s"$baseUrl/$route/what-you-will-need")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postFinancialYearEndDatesSummary(option: String): HttpRequestBuilder =
    http("[GET] get financial year end dates summary page")
      .post(s"$baseUrl/$route/financial-year-end-dates-summary")
      .formParamMap(Map(
        "isFinancialYearEndDatesCorrect" -> option,
        "csrfToken" -> f"$${csrfToken}"
      ))

  def postElectricityGenerated(weeks: Int, electricity: String): HttpRequestBuilder =
    http("[POST] post electricity generated page")
      .post(s"$baseUrl/$route/electricity-generated")
      .formParam("turnover[0].weeks", weeks)
      .formParam("turnover[0].electricityGenerated", electricity)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

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

  def postTurnOver6030(income: String, visitors: String): HttpRequestBuilder =
    http("[POST] post turnover page")
      .post(s"$baseUrl/$route/turnover-6030")
      .formParamMap(Map(
        "0.weeks" -> "52",
        "0.grossIncome" -> income,
        "totalVisitorNumber" -> visitors,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

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

  def postTotalPayrollCosts(managerAndStaff: String, remuneration: String): HttpRequestBuilder =
    http("[POST] POST total payroll costs page")
      .post(s"$baseUrl/$route/total-payroll-costs")
      .formParamMap(Map(
        "totalPayrollCosts[0].managers-and-staff" -> managerAndStaff,
        "totalPayrollCosts[0].directors-remuneration" -> remuneration,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  def postVariableOperatingExpenses(energyAndUtilities: String, cleaningAndLaundry: String, buildingMaintenanceAndRepairs: String, fixturesFittingsAndEquipment: String, advertisingAndPromotions: String, administrationAndSundries: String, entertainment: String, other: String, otherExpensesDetails: String): HttpRequestBuilder =
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

  def postFixedOperatingExpenses(rent: String, businessRates: String, insurance: String, loanInterest: String, depreciation: String): HttpRequestBuilder =
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

  def postOtherCosts(contributionsToHeadOffice: String, otherCosts: String, otherCostsDetails: String): HttpRequestBuilder =
    http("[POST] post other costs page")
      .post(s"$baseUrl/$route/other-costs")
      .formParamMap(Map(
        "otherCosts[0].contributionsToHeadOffice" -> contributionsToHeadOffice,
        "otherCosts[0].otherCosts" -> otherCosts,
        "otherCostDetails" -> otherCostsDetails,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  def postIncomeExpenditureSummary(option: String): HttpRequestBuilder =
    http("[POST] post income expenditure summary page")
      .post(s"$baseUrl/$route/income-expenditure-summary")
      .formParam("incomeExpenditureSummary", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postUnusualCircumstances(details: String): HttpRequestBuilder =
    http("[POST] post unusual circumstances page")
      .post(s"$baseUrl/$route/unusual-circumstances")
      .formParam("unusualCircumstances", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postCYAAboutTradingHistory(option: String): HttpRequestBuilder =
    http("[POST] post cya about your trading history")
      .post(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .formParam("checkYourAnswersAboutTheTradingHistory", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postTotalFuelSold(answer: String): HttpRequestBuilder =
    http("[POST] post total fuel sold")
      .post(s"$baseUrl/$route/total-fuel-sold")
      .formParam("totalFuelSold-0", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkeredFuelQuestion(option: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel question page")
      .post(s"$baseUrl/$route/bunkered-fuel-question")
      .formParam("bunkeredFuelQuestion", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkeredFuelSold(option: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel sold page")
      .post(s"$baseUrl/$route/bunkered-fuel-sold")
      .formParam("bunkeredFuelSold-0", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkerFuelCardsDetails(answer1: String, answer2: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel card details page")
      .post(s"$baseUrl/$route/bunker-fuel-cards-details")
      .formParam("name", answer1)
      .formParam("handlingFee", answer2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAddAnotherBunkerFuelCardsDetails(option: String): HttpRequestBuilder =
    http("[POST] post add another bunker fuel card details page")
      .post(s"$baseUrl/$route/add-another-bunker-fuel-cards-details")
      .formParam("addAnotherBunkerFuelCardsDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postCustomerCreditAccounts(option: String): HttpRequestBuilder =
    http("[POST] post customer credit accounts page")
      .post(s"$baseUrl/$route/customer-credit-accounts")
      .formParam("customerCreditAccounts-0", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAcceptLowMarginFuelCard(option: String): HttpRequestBuilder =
    http("[POST] post accept low Margin Fuel Card")
      .post(s"$baseUrl/$route/accept-low-margin-fuel-card")
      .formParam("acceptLowMarginFuelCard", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postPercentageFromFuelCards(answer: String): HttpRequestBuilder =
    http("[POST] post percentage from fuel card page")
      .post(s"$baseUrl/$route/percentage-from-fuel-cards")
      .formParam("percentageFromFuelCards-0", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postLowMarginFuelCardsDetails(answer1: String, answer2: String): HttpRequestBuilder =
    http("[POST] post low margin fuel cards details page")
      .post(s"$baseUrl/$route/low-margin-fuel-cards-details")
      .formParam("name", answer1)
      .formParam("handlingFee", answer2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAddAnotherLowMarginFuelCardDetails(option: String): HttpRequestBuilder =
    http("[POST] post add another low margin fuel cards details page")
      .post(s"$baseUrl/$route/add-another-low-margin-fuel-cards-details")
      .formParam("addAnotherLowMarginFuelCardsDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postNonFuelTurnOver(shop: String, carWash: String, jetWash: String, lottery: String, payPointOrZone: String, otherIncome: String): HttpRequestBuilder =
    http("[POST] post non fuel turn over page")
      .post(s"$baseUrl/$route/non-fuel-turnover")
      .formParamMap(Map(
        "turnover[0].shop" -> shop,
        "turnover[0].carWash" -> carWash,
        "turnover[0].jetWash" -> jetWash,
        "turnover[0].lottery" -> lottery,
        "turnover[0].payPointOrZone" -> payPointOrZone,
        "turnover[0].otherIncome" -> otherIncome,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def postElectricVehicleChargingPoints(option: String, answer: String): HttpRequestBuilder =
    http("[POST] post electric vehicle charging points page")
      .post(s"$baseUrl/$route/electric-vehicle-charging-points")
      .formParam("electricVehicleChargingPoints", option)
      .formParam("spacesOrBays", answer)

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

  val TradingHistorySectionFor6020: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDatesSummary,
    postFinancialYearEndDatesSummary("true"),
    getTotalFuelSold,
    postTotalFuelSold("100"),
    getBunkeredFuelQuestion,
    postBunkeredFuelQuestion("yes"),
    getBunkeredFuelSold,
    postBunkeredFuelSold("50"),
    getBunkerFuelCardsDetails,
    postBunkerFuelCardsDetails("shell", "23.5"),
    getAddAnotherBunkerFuelCardsDetails,
    postAddAnotherBunkerFuelCardsDetails("no"),
    getCustomerCreditAccounts,
    postCustomerCreditAccounts("30"),
    getAcceptLowMarginFuelCard,
    postAcceptLowMarginFuelCard("yes"),
    getPercentageFromFuelCards,
    postPercentageFromFuelCards("100"),
    getLowMarginFuelCardsDetails,
    postLowMarginFuelCardsDetails("shell", "23.5"),
    getAddAnotherLowMarginFuelCardDetails,
    postAddAnotherLowMarginFuelCardDetails("no"),
    getNonFuelTurnOver,
    postNonFuelTurnOver("22", "223", "123", "67", "789", "67"),
    getElectricVehicleChargingPoints,
    postElectricVehicleChargingPoints("yes", "12"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes"))

  val TradingHistorySectionFor6030: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOver6030,
    postTurnOver6030("1234", "50"),
    getUnusualCircumstances,
    postUnusualCircumstances("Details of unusual circumstances"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes"))

  val TradingHistorySectionFor6076: Seq[HttpRequestBuilder] = Seq(
    getWhatYouWillNeed,
    postWhatYouWillNeed,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDatesSummary,
    postFinancialYearEndDatesSummary("true"),
    getElectricityGenerated,
    postElectricityGenerated(26, "10KW"),
    getGrossReceiptsExcludingVat,
    postGrossReceiptsExcludingVat,
    getOtherIncome,
    postOtherIncome,
    getCostOfSalesIntermittent,
    postCostOfSalesIntermittent,
    getStaffCosts,
    postStaffCosts,
    getPremisesCosts,
    postPremiseCosts,
    getOperationalExpenses,
    postOperationalExpenses,
    getHeadOfficeExpenses,
    postHeadOfficeExpenses,
    getIncomeExpenditureSummary6076,
    postIncomeExpenditureSummary6076,
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes"))


}

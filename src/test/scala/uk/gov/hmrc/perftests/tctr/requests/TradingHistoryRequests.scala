/*
 * Copyright 2023 HM Revenue & Customs
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
      .formParam("firstOccupy.month", today.month)
      .formParam("firstOccupy.year", today.year)
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
        "0.financial-year-end.day" -> today.day,
        "0.financial-year-end.month" -> today.month,
        "0.financial-year-end.year" -> today.year,
        "0.weeks" -> "52",
        "0.alcoholic-drinks" -> AlcoholDrinks,
        "0.food" -> Food,
        "0.other-receipts" -> otherReceipts,
        "0.accommodation" -> accommodation,
        "0.average-occupancy-rate" -> averageOccupancyRate,
        "csrfToken" -> f"$${csrfToken}"))
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
}

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
      .formParam("firstOccupy.month", pastMonth.month)
      .formParam("firstOccupy.year", today.year)
      .formParam("financialYear.day", today.day)
      .formParam("financialYear.month", today.month)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTurnOverPage: HttpRequestBuilder =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTurnOver(AlcoholDrinks: Int, Food: Int, otherReceipts: Int, accommodation: Int, averageOccupancyRate:Int): HttpRequestBuilder =
    http("[POST] post turnover page")
      .post(s"$baseUrl/$route/turnover")
      .formParam("0.financial-year-end", financialYearEndFormatter.format(today))
      .formParam("0.weeks", "52")
      .formParam("0.alcoholic-drinks", AlcoholDrinks)
      .formParam("0.food", Food)
      .formParam("0.other-receipts", otherReceipts)
      .formParam("0.accommodation", accommodation)
      .formParam("0.average-occupancy-rate", averageOccupancyRate)
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


  val TradingHistorySectionFor6011: Seq[HttpRequestBuilder] = Seq(
    getTaskListPage,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340,230, 30),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
}

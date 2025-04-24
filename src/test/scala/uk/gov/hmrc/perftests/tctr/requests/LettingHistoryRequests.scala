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
import utils.DateUtils._

object LettingHistoryRequests extends HttpConfiguration with servicesConfig {

  val getLettingHistoryHasPermanentResidents: HttpRequestBuilder =
    http("[GET] get letting history has permanent residents page")
      .get(s"$baseUrl/$route/letting-history-has-permanent-residents")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryHasPermanentResidents(answer: String): HttpRequestBuilder =
    http("[POST] post letting history has permanent residents page")
      .post(s"$baseUrl/$route/letting-history-has-permanent-residents")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryResidentDetail: HttpRequestBuilder =
    http("[GET] get letting history resident detail")
      .get(s"$baseUrl/$route/letting-history-resident-detail")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryResidentDetail(name: String, address: String): HttpRequestBuilder =
    http("[POST] post letting history resident detail")
      .post(s"$baseUrl/$route/letting-history-resident-detail")
      .formParam("name", name)
      .formParam("address", address)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryResidentList: HttpRequestBuilder =
    http("[GET] get letting history resident list")
      .get(s"$baseUrl/$route/letting-history-resident-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryResidentList(answer: String): HttpRequestBuilder =
    http("[POST] post letting history resident list")
      .post(s"$baseUrl/$route/letting-history-resident-list")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryHasCompletedLettings: HttpRequestBuilder =
    http("[GET] get letting history has completed lettings")
      .get(s"$baseUrl/$route/letting-history-has-completed-lettings")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryHasCompletedLettings(answer: String): HttpRequestBuilder =
    http("[POST] post letting history has completed lettings")
      .post(s"$baseUrl/$route/letting-history-has-completed-lettings")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryOccupierDetail: HttpRequestBuilder =
    http("[GET] get letting history occupier details")
      .get(s"$baseUrl/$route/letting-history-occupier-detail")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryOccupierDetail(name: String, addressLine1: String, addressLine2: String, town: String, county: String, postcode: String): HttpRequestBuilder =
    http("[POST] post letting history occupier details")
      .post(s"$baseUrl/$route/letting-history-occupier-detail")
      .disableFollowRedirect
      .formParam("name", name)
      .formParam("address.line1", addressLine1)
      .formParam("address.line2", addressLine2)
      .formParam("address.town", town)
      .formParam("address.county", county)
      .formParam("address.postcode", postcode)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryRentalPeriod: HttpRequestBuilder =
    http("[GET] get letting history rental period")
      .get(s"$baseUrl/$route/letting-history-rental-period")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryRentalPeriod(day1: Int, month1: Int, year1: Int, day2: Int, month2: Int, year2: Int): HttpRequestBuilder =
    http("[POST] post letting history rental period")
      .post(s"$baseUrl/$route/letting-history-rental-period")
      .disableFollowRedirect
      .formParam("fromDate.day", day1)
      .formParam("fromDate.month", month1)
      .formParam("fromDate.year", year1)
      .formParam("toDate.day", day2)
      .formParam("toDate.month", month2)
      .formParam("toDate.year", year2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryOccupierList: HttpRequestBuilder =
    http("[GET] get letting history occupier list")
      .get(s"$baseUrl/$route/letting-history-occupier-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryOccupierList(answer: String): HttpRequestBuilder =
    http("[POST] post letting history occupier list")
      .post(s"$baseUrl/$route/letting-history-occupier-list")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryHowManyNights: HttpRequestBuilder =
    http("[GET] get letting history how many nights")
      .get(s"$baseUrl/$route/letting-history-how-many-nights")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryHowManyNights(answer: Int): HttpRequestBuilder =
    http("[POST] post letting history how many nights")
      .post(s"$baseUrl/$route/letting-history-how-many-nights")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryIsYearlyAvailable: HttpRequestBuilder =
    http("[GET] get letting history is yearly available")
      .get(s"$baseUrl/$route/letting-history-is-yearly-available")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryAdvertisingList(answer: String): HttpRequestBuilder =
    http("[POST] post letting history is yearly available")
      .post(s"$baseUrl/$route/letting-history-is-yearly-available")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryHasOnlineAdvertising: HttpRequestBuilder =
    http("[GET] get letting history has online advertising")
      .get(s"$baseUrl/$route/letting-history-has-online-advertising")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryHasOnlineAdvertising(answer: String): HttpRequestBuilder =
    http("[POST] post letting history has online advertising")
      .post(s"$baseUrl/$route/letting-history-has-online-advertising")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryAdvertisingDetail: HttpRequestBuilder =
    http("[GET] get letting history advertising detail")
      .get(s"$baseUrl/$route/letting-history-advertising-detail")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryAdvertisingDetail(address: String, refNumber: String): HttpRequestBuilder =
    http("[POST] post letting history advertising detail")
      .post(s"$baseUrl/$route/letting-history-advertising-detail")
      .formParam("websiteAddress", address)
      .formParam("propertyReferenceNumber", refNumber)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingHistoryAdvertisingList: HttpRequestBuilder =
    http("[GET] get letting history advertising list")
      .get(s"$baseUrl/$route/letting-history-advertising-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingHistoryIsYearlyAvailable(answer: String): HttpRequestBuilder =
    http("[POST] post letting history advertising list")
      .post(s"$baseUrl/$route/letting-history-advertising-list")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYALettingHistory: HttpRequestBuilder =
    http("[GET] get letting history check your answers")
      .get(s"$baseUrl/$route/letting-history-check-your-answers")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYALettingHistory(answer: String): HttpRequestBuilder =
    http("[POST] post letting history check your answers")
      .post(s"$baseUrl/$route/letting-history-check-your-answers")
      .formParam("answer", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val lettingHistorySectionFor6048: Seq[HttpRequestBuilder] = Seq(
    getLettingHistoryHasPermanentResidents,
    postLettingHistoryHasPermanentResidents("yes"),
    getLettingHistoryResidentDetail,
    postLettingHistoryResidentDetail("Tom Hitchings", "Test Street, Test City, BN12 6AB"),
    getLettingHistoryResidentList,
    postLettingHistoryResidentList("no"),
    getLettingHistoryHasCompletedLettings,
    postLettingHistoryHasCompletedLettings("yes"),
    getLettingHistoryOccupierDetail,
    postLettingHistoryOccupierDetail("Dru", "1 Guild Hall","", "SandHill", "","NE1 3AF"),
    getLettingHistoryRentalPeriod,
    postLettingHistoryRentalPeriod(21,8,2024,22,2,2025),
    getLettingHistoryOccupierList,
    postLettingHistoryOccupierList("no"),
    getLettingHistoryHowManyNights,
    postLettingHistoryHowManyNights(120),
    getLettingHistoryIsYearlyAvailable,
    postLettingHistoryIsYearlyAvailable("yes"),
    getLettingHistoryHasOnlineAdvertising,
    postLettingHistoryHasOnlineAdvertising("yes"),
    getLettingHistoryAdvertisingDetail,
    postLettingHistoryAdvertisingDetail("test@onlineadvertising.com", "4123456"),
    getLettingHistoryAdvertisingList,
    postLettingHistoryAdvertisingList("no"),
    getCYALettingHistory,
    postCYALettingHistory("yes"))

}

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

object AccommodationDetailsRequests extends HttpConfiguration with servicesConfig {

  val getAccommodationUnit: HttpRequestBuilder =
    http("[GET] get accommodation unit page")
      .get(s"$baseUrl/$route/accommodation-unit")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAccommodationUnit(unitName: String, unitType: String): HttpRequestBuilder =
    http("[POST] post accommodation unit page")
      .post(s"$baseUrl/$route/accommodation-unit")
      .formParam("unitName", unitName)
      .formParam("unitType", unitType)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAvailableRooms: HttpRequestBuilder =
  http("[GET] get available rooms page")
      .get(s"$baseUrl/$route/available-rooms")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAvailableRooms(sinBed: Int, douBed: Int, bath: Int, acom: String, guests: Int): HttpRequestBuilder =
  http("[POST] post available rooms page")
      .post(s"$baseUrl/$route/available-rooms")
      .formParam("singleBedrooms", sinBed)
      .formParam("doubleBedrooms", douBed)
      .formParam("bathrooms", bath)
      .formParam("otherAccommodationDescription", acom)
      .formParam("maxGuestsNumber", guests)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAccommodationLettingHistory: HttpRequestBuilder =
    http("[GET] get accommodation letting history page")
      .get(s"$baseUrl/$route/accommodation-letting-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAccommodationLettingHistory(nights: Int, nightsLet: Int, weeks: Int): HttpRequestBuilder =
    http("[POST] post accommodation letting history page")
      .post(s"$baseUrl/$route/accommodation-letting-history")
      .formParam("lettingHistory[0].nightsAvailableToLet", nights)
      .formParam("lettingHistory[0].nightsLet", nightsLet)
      .formParam("lettingHistory[0].weeksAvailableForPersonalUse", weeks)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getHighSeasonTariff: HttpRequestBuilder =
    http("[GET] get high season tariff page")
      .get(s"$baseUrl/$route/high-season-tariff")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postHighSeasonTariff(day1: Int, month1: Int, year1: Int, day2: Int, month2: Int, year2: Int): HttpRequestBuilder =
    http("[POST] post high season tariff page")
      .post(s"$baseUrl/$route/high-season-tariff")
      .disableFollowRedirect
      .formParam("fromDate.day", day1)
      .formParam("fromDate.month", month1)
      .formParam("fromDate.year", year1)
      .formParam("toDate.day", day2)
      .formParam("toDate.month", month2)
      .formParam("toDate.year", year2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIncludedTariffItem: HttpRequestBuilder =
    http("[GET] get included tariff item page")
      .get(s"$baseUrl/$route/included-tariff-item")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIncludedTariffItem(option1: String): HttpRequestBuilder =
    http("[POST] post included tariff item page")
      .post(s"$baseUrl/$route/included-tariff-item")
      .formParam("includedTariffItems[]", option1)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAccommodationUnitList: HttpRequestBuilder =
    http("[GET] get accommodation unit list page")
      .get(s"$baseUrl/$route/accommodation-unit-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAccommodationUnitList(answer: String): HttpRequestBuilder =
    http("[POST] post accommodation unit list page")
      .post(s"$baseUrl/$route/accommodation-unit-list")
      .formParam("addMoreAccommodationUnits", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYAAccommodationDetails: HttpRequestBuilder =
    http("[GET] get cya for accommodation details")
      .get(s"$baseUrl/$route/check-your-answers-accommodation-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAAccommodationDetails(option: String): HttpRequestBuilder =
    http("[POST] post cya for accommodation details")
      .post(s"$baseUrl/$route/check-your-answers-accommodation-details")
      .formParam("checkYourAnswersAccommodationDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val AccommodationDetailsSectionFor6048: Seq[HttpRequestBuilder] = Seq(
    getAccommodationUnit,
    postAccommodationUnit("Barn Unit", "Catering"),
    getAvailableRooms,
    postAvailableRooms(5, 3, 5, "Media room", 11),
    getAccommodationLettingHistory,
    postAccommodationLettingHistory(12, 21, 21),
    getHighSeasonTariff,
    postHighSeasonTariff(12, 12, 2024, 21, 3, 2025),
    getIncludedTariffItem,
    postIncludedTariffItem("gas"),
    getAccommodationUnitList,
    postAccommodationUnitList("no"),
    getCYAAccommodationDetails,
    postCYAAccommodationDetails("yes"))
}

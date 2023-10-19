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
import utils.DateUtils._

object LeaseOrAgreementRequests extends HttpConfiguration with servicesConfig {

  val getAboutYourLandlord: HttpRequestBuilder =
    http("[GET] get about your landlord page")
      .get(s"$baseUrl/$route/about-your-landlord")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAboutYourLandlord(name: String, buildingNameNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post about your landlord page")
      .post(s"$baseUrl/$route/about-your-landlord")
      .formParamMap(Map(
        "landlordFullName" -> name,
        "landlordAddress.buildingNameNumber" -> buildingNameNumber,
        "landlordAddress.town" -> town,
        "landlordAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getConnectionToLandlord: HttpRequestBuilder =
    http("[GET] get connection to landlord page")
      .get(s"$baseUrl/$route/connected-to-landlord")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postConnectionToLandlord(option: String): HttpRequestBuilder =
    http("[POST] post connection to landlord")
      .post(s"$baseUrl/$route/connected-to-landlord")
      .formParam("connectedToLandlord", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getConnectedLandlordDetails: HttpRequestBuilder =
    http("[GET] get connected landlord details")
      .get(s"$baseUrl/$route/connected-to-landlord-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postConnectedLandlordDetails(details: String): HttpRequestBuilder =
    http("[POST] post connected landlord details")
      .post(s"$baseUrl/$route/connected-to-landlord-details")
      .formParam("connectedToLandlordDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLeaseOAgreementDetails: HttpRequestBuilder =
    http("[GET] get lease or agreement details page")
      .get(s"$baseUrl/$route/lease-or-agreement-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLeaseOrAgreementDetails(option: String): HttpRequestBuilder =
    http("[POST] post lease or agreement details page")
      .post(s"$baseUrl/$route/lease-or-agreement-details")
      .formParamMap(Map(
        "commenceWithinThreeYears" -> option,
        "agreedReviewedAlteredThreeYears" -> option,
        "rentUnderReviewNegotiated" -> option,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getPropertyUseLeaseBackArrangement: HttpRequestBuilder =
    http("[GET] get property use lease back arrangement page")
      .get(s"$baseUrl/$route/property-use-leaseback-arrangement")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPropertyUseLeaseBackArrangement(option: String): HttpRequestBuilder =
    http("[POST] post property use lease back arrangement page")
      .post(s"$baseUrl/$route/property-use-leaseback-arrangement")
      .formParam("propertyUseLeasebackArrangement", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCurrentAnnualRent: HttpRequestBuilder =
    http("[GET] get current annual rent page")
      .get(s"$baseUrl/$route/current-annual-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCurrentAnnualRent(rent: String): HttpRequestBuilder =
    http("[POST] post current annual rent page")
      .post(s"$baseUrl/$route/current-annual-rent")
      .formParam("currentAnnualRent", rent)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentIncludesVat: HttpRequestBuilder =
    http("[GET] get rent includes VAT page")
      .get(s"$baseUrl/$route/rent-includes-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludesVat(option: String): HttpRequestBuilder =
    http("[POST] post rent includes VAT page")
      .post(s"$baseUrl/$route/rent-includes-vat")
      .formParam("rentIncludesVat", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))



  val getCurrentRentFirstPaid: HttpRequestBuilder =
    http("[GET] get current rent first paid page")
      .get(s"$baseUrl/$route/current-rent-first-paid")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCurrentRentFirstPaid: HttpRequestBuilder =
    http("[POST] post current rent first paid page")
      .post(s"$baseUrl/$route/current-rent-first-paid")
      .formParamMap(Map(
        "currentRentFirstPaid.day" -> today.day,
        "currentRentFirstPaid.month" -> pastMonth.month,
        "currentRentFirstPaid.year" -> today.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCurrentLeaseOrAgreementBegin: HttpRequestBuilder =
    http("[GET] get current lease or agreement begin page")
      .get(s"$baseUrl/$route/current-lease-or-agreement-begin")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCurrentLeaseOrAgreementBegin(text: String): HttpRequestBuilder =
    http("[POST] post current lease or agreement begin page")
      .post(s"$baseUrl/$route/current-lease-or-agreement-begin")
      .formParamMap(Map(
        "leaseBegin.month" -> pastMonth.month,
        "leaseBegin.year" -> pastYear.year,
        "grantedFor" -> text,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getTenancyLeaseAgreementExpire : HttpRequestBuilder =
    http("[GET] get tenancy lease agreement expire page")
      .get(s"$baseUrl/$route/tenancy-lease-agreement-expire")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTenancyLeaseAgreementExpire: HttpRequestBuilder =
    http("[POST] post tenancy lease agreement expire page")
      .post(s"$baseUrl/$route/tenancy-lease-agreement-expire")
      .formParamMap(Map(
        "tenancyLeaseAgreementExpire.day" -> today.day,
        "tenancyLeaseAgreementExpire.month" -> nextMonth.month,
        "tenancyLeaseAgreementExpire.year" -> nextYear.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCYALeaseOrTenure: HttpRequestBuilder =
    http("[GET] get cya for lease or tenure page")
      .get(s"$baseUrl/$route/check-your-answers-lease-or-tenure")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYALeaseOrTenure(option: String): HttpRequestBuilder =
    http("[POST] post cya for lease or tenure page")
      .post(s"$baseUrl/$route/check-your-answers-lease-or-tenure")
      .formParam("checkYourAnswersLeaseOrTenure", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val leaseOrAgreementSectionFor6011: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlord("Dru", "11 bannana valley", "Minions", "BN12 4AX"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Details of teh landlord relationship"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1234"),
    getRentIncludesVat,
    postRentIncludesVat("yes"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getTenancyLeaseAgreementExpire,
    postTenancyLeaseAgreementExpire,
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes")
  )
}

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

object tctrRequests extends HttpConfiguration with servicesConfig {

  val getHomePage: HttpRequestBuilder =
    http("[GET] Get send trade and cost information start page")
      .get(s"$baseUrl/$route")
      .check(status.is(200))

  val getRequestReferenceNumberWithSession: HttpRequestBuilder =
    http("[GET] get request reference number with session")
      .get(s"$baseUrl/$route/request-reference-number-with-session")
      .check(status.is(303))

  val getRequestReferenceNumber: HttpRequestBuilder =
    http("[GET] get request reference number")
      .get(s"$baseUrl/$route/request-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRequestReferenceNumber(name: String, buildingNum: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post request reference number page")
      .post(s"$baseUrl/$route/request-reference-number")
      .disableFollowRedirect
      .formParam("requestReferenceNumberBusinessTradingName", name)
      .formParam("requestReferenceNumberAddress.buildingNameNumber", buildingNum)
      .formParam("requestReferenceNumberAddress.town", town)
      .formParam("requestReferenceNumberAddress.postcode", postcode)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRequestReferenceNumberContactDetails: HttpRequestBuilder =
    http("[GET] get request reference number contact details page")
      .get(s"$baseUrl/$route/request-reference-number-contact-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRequestReferenceNumberContactDetails(name: String, buildingNum: String, email: String): HttpRequestBuilder =
    http("[POST] post request reference number contact details page")
      .post(s"$baseUrl/$route/request-reference-number-contact-details")
      .disableFollowRedirect
      .formParam("requestReferenceNumberContactDetailsFullName", name)
      .formParam("requestReferenceNumberContactDetails.phone", buildingNum)
      .formParam("requestReferenceNumberContactDetails.email", email)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYARequestReferenceNumber: HttpRequestBuilder =
    http("[GET] get cya for request reference number page")
      .get(s"$baseUrl/$route/check-your-answers-request-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCYARequestReferenceNumber: HttpRequestBuilder =
    http("[POST] post cya for request reference number page")
      .post(s"$baseUrl/$route/check-your-answers-request-reference-number")
      .disableFollowRedirect
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(302))

  val getConfirmationRequestReferenceNumber: HttpRequestBuilder =
    http("[GET] get confirmation request reference number")
      .get(s"$baseUrl/$route/confirmation-request-reference-number")
      .check(status.is(200))

  val getDownloadPdfReferenceNumber: HttpRequestBuilder =
    http("[GET] get download pdf reference number page")
      .get(s"$baseUrl/$route/download-pdf-reference-number")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postDownloadPdfReferenceNumber: HttpRequestBuilder =
    http("[POST] post download pdf reference number page")
      .post(s"$baseUrl/$route/download-pdf-reference-number")
      .disableFollowRedirect
      .formParam("downloadPdfReferenceNumber", f"$referenceNumberFor6010")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getLoginPage: HttpRequestBuilder =
    http("[GET] Get send trade and cost information login page")
      .get(s"$baseUrl/$route/login")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLoginPage(postcode: String): HttpRequestBuilder =
    http("[POST] Login with reference number and postcode page")
      .post(s"$baseUrl/$route/login")
      .formParam("referenceNumber", f"$referenceNumberFor6010")
      .formParam("continue_button", "continue_button")
      .formParam("postcode", postcode)
      .formParam("start-time", dateTime)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAreYouStillConnectedPage: HttpRequestBuilder =
    http("[GET] Get are you still connected page")
      .get(s"$baseUrl/$route/are-you-still-connected")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAreYouStillConnectedPage(option: String): HttpRequestBuilder =
    http("[POST] post are you still connected page")
      .post(s"$baseUrl/$route/are-you-still-connected")
      .disableFollowRedirect
      .formParam("isRelated", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getEditAddressPage: HttpRequestBuilder =
    http("[GET] get edit address page")
      .get(s"$baseUrl/$route/edit-address")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postEditAddressPage(BuildingNum: String, town: String, postcode:String): HttpRequestBuilder =
    http("[POST] post edit address page")
      .post(s"$baseUrl/$route/edit-address")
      .disableFollowRedirect
      .formParam("editAddress.buildingNameNumber", BuildingNum)
      .formParam("editAddress.town", town)
      .formParam("editAddress.postcode", postcode)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPastConnectionType: HttpRequestBuilder =
    http("[GET] get past connection type page")
      .get(s"$baseUrl/$route/past-connection-type")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPastConnectionType(option: String): HttpRequestBuilder =
    http("[GET] get past connection type page")
      .post(s"$baseUrl/$route/past-connection-type")
      .disableFollowRedirect
      .formParam("pastConnectionType", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRemoveConnection: HttpRequestBuilder =
    http("[GET] get remove connection page")
      .get(s"$baseUrl/$route/remove-connection")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveConnection(name: String, telephone: String, email: String): HttpRequestBuilder =
    http("[POST] post remove connection page")
      .post(s"$baseUrl/$route/remove-connection")
      .disableFollowRedirect
      .formParam("removeConnectionFullName", name)
      .formParam("removeConnectionDetails.phone", telephone)
      .formParam("removeConnectionDetails.email", email)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYANotConnected: HttpRequestBuilder =
    http("[GET] get cya not connected page")
      .get(s"$baseUrl/$route/check-your-answers-not-connected")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCYANotConnected: HttpRequestBuilder =
    http("[POST] post cya not connected page")
      .post(s"$baseUrl/$route/check-your-answers-not-connected")
      .disableFollowRedirect
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(302))

  val getVacantPropertiesPage: HttpRequestBuilder =
    http("[GET] Get vacant properties page")
      .get(s"$baseUrl/$route/vacant-properties")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postVacantProperties(option: String): HttpRequestBuilder =
    http("[POST] post vacant properties")
      .post(s"$baseUrl/$route/vacant-properties")
      .disableFollowRedirect
      .formParam("vacantProperties", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getVacantPropertyStartDate: HttpRequestBuilder =
    http("[GET] get vacant property start date")
      .get(s"$baseUrl/$route/vacant-property-start-date")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postVacantPropertyStartDate: HttpRequestBuilder =
    http("[POST] post vacant property start date")
      .post(s"$baseUrl/$route/vacant-property-start-date")
      .disableFollowRedirect
      .formParam("startDateOfVacantProperty.day", pastMonth.day)
      .formParam("startDateOfVacantProperty.month", pastMonth.month)
      .formParam("startDateOfVacantProperty.year", pastMonth.year)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIsRentReceivedFromLetting: HttpRequestBuilder =
    http("[GET} get letting income page")
      .get(s"$baseUrl/$route/is-rent-received-from-letting")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIsRentReceivedFromLetting(option: String): HttpRequestBuilder =
    http("[POST] post letting income page")
      .post(s"$baseUrl/$route/is-rent-received-from-letting")
      .disableFollowRedirect
      .formParam("isRentReceivedFromLetting", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLettingPartOfPropertyDetails: HttpRequestBuilder =
    http("[GET] get letting part of property tenant details")
      .get(s"$baseUrl/$route/letting-part-of-property-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingPartOfPropertyDetails(name: String, description: String, addressLine1: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post letting part of property tenant details")
      .post(s"$baseUrl/$route/letting-part-of-property-details")
      .disableFollowRedirect
      .formParam("tenantName", name)
      .formParam("descriptionOfLetting", description)
      .formParam("correspondenceAddress.addressLineOne", addressLine1)
      .formParam("correspondenceAddress.town", town)
      .formParam("correspondenceAddress.postcode", postcode)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getLettingPartOfPropertyRent(index: Int): HttpRequestBuilder =
    http("[GET] get annual rent page")
      .get(s"$baseUrl/$route/letting-part-of-property-rent?idx=$index")
      .queryParam("idx",index)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingPartOfPropertyRent(index: Int, rent: Long): HttpRequestBuilder =
    http("[POST] get annual rent page")
      .post(s"$baseUrl/$route/letting-part-of-property-rent?idx=$index")
      .disableFollowRedirect
      .formParam("annualRent", rent)
      .formParam("dateInput.day", pastMonth.day)
      .formParam("dateInput.month", pastMonth.month)
      .formParam("dateInput.year", pastMonth.year)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getLettingPartOfPropertyCheckBox(index: Int): HttpRequestBuilder =
    http("[GET] get rent included checkboxes page")
      .get(s"$baseUrl/$route/letting-part-of-property-checkbox?idx=$index")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingPartOfPropertyCheckBox(index: Int, option1: String, option2: String): HttpRequestBuilder =
    http("[POST] get rent included checkboxes page")
      .post(s"$baseUrl/$route/letting-part-of-property-checkbox?idx=$index")
      .disableFollowRedirect
      .formParam("itemsInRent[]", option1)
      .formParam("itemsInRent[]", option2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getAddAnotherLettingPartOfProperty(index: Int): HttpRequestBuilder =
    http("[GET] get add another letting part of the property")
      .get(s"$baseUrl/$route/add-another-letting-part-of-property?idx=$index")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherLettingPartOfProperty(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post add another letting part of the property")
      .post(s"$baseUrl/$route/add-another-letting-part-of-property?idx=$index")
      .disableFollowRedirect
      .formParam("addAnotherLettingPartOfProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getYourContactDetails: HttpRequestBuilder =
    http("[GET] get your contact details page")
      .get(s"$baseUrl/$route/your-contact-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postYourContactDetails(name: String, email: String, telephone: String): HttpRequestBuilder =
    http("[POST] post contact details")
      .post(s"$baseUrl/$route/your-contact-details")
      .disableFollowRedirect
      .formParam("yourContactDetails.fullName", name)
      .formParam("yourContactDetails.contactDetails.email", email)
      .formParam("yourContactDetails.contactDetails.phone", telephone)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYAToVacantProperty: HttpRequestBuilder =
    http("[GET] get cya for vacant property page")
      .get(s"$baseUrl/$route/check-your-answers-connection-to-vacant-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  //  #TODO: The url for the POST on the cya page is taking a different url
  val postCYAToVacantProperty: HttpRequestBuilder =
    http("[POST] post cya for vacant property page")
      .post(s"$baseUrl/$route/connection-to-property-declaration")
      .disableFollowRedirect
      .formParam("csrfToken", f"$${csrfToken}")
      .formParam("continue_button", "continue_button")
      .check(status.is(303))

  val getDeclarationSentForVacantProperty: HttpRequestBuilder =
    http("[GET] get declaration for vacant property page")
      .get(s"$baseUrl/$route/connection-to-property-confirmation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTaskListPage: HttpRequestBuilder =
    http("[GET] get task list page")
      .get(s"$baseUrl/$route/task-list")
      .check(status.is(200))

  val getNameOfOperatorFromProperty: HttpRequestBuilder =
    http("[GET] get name of operator from property page")
      .get(s"$baseUrl/$route/name-of-operator-from-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postNameOfOperatorFromProperty(name: String): HttpRequestBuilder =
    http("[POST] post name of operator from property page")
      .post(s"$baseUrl/$route/name-of-operator-from-property")
      .formParam("tradingNameFromProperty", name)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val alternativeFormatLinkToDownloadPdf: Seq[HttpRequestBuilder] = Seq(
    getHomePage
  )

  val downloadPdfVersion: Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    getDownloadPdfReferenceNumber,
    postDownloadPdfReferenceNumber
  )

  val requestReferenceNumberJourney: Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    getRequestReferenceNumberWithSession,
    getRequestReferenceNumber,
    postRequestReferenceNumber("Minions", "Bannana valley", "London", "BN12 4AX"),
    getRequestReferenceNumberContactDetails,
    postRequestReferenceNumberContactDetails("Dru", "01234567891", "eu@example.com"),
    getCYARequestReferenceNumber,
    postCYARequestReferenceNumber,
    getConfirmationRequestReferenceNumber
  )

  val submit6010ForVacantProperty: Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX"),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes-change-address"),
    getEditAddressPage,
    postEditAddressPage("999", "GORING-BY-SEA,+WORTHING", "BN12+4AX"),
    getVacantPropertiesPage,
    postVacantProperties("yes"),
    getVacantPropertyStartDate,
    postVacantPropertyStartDate,
    getIsRentReceivedFromLetting,
    postIsRentReceivedFromLetting("yes"),
    getLettingPartOfPropertyDetails,
    postLettingPartOfPropertyDetails("HardRockCafe", "Dine-in", "1 Guild Hall", "SandHill", "NE1 3AF"),
    getLettingPartOfPropertyRent(0),
    postLettingPartOfPropertyRent(0, 10000),
    getLettingPartOfPropertyCheckBox(0),
    postLettingPartOfPropertyCheckBox(0, "rates", "outsideRepairs"),
    getAddAnotherLettingPartOfProperty(0),
    postAddAnotherLettingPartOfProperty(0, "no"),
    getYourContactDetails,
    postYourContactDetails("sundae", "minion@example.com", "01234567899"),
    getCYAToVacantProperty,
    postCYAToVacantProperty,
    getDeclarationSentForVacantProperty
  )

  val submit6010ForNotConnectedToProperty: Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX"),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("no"),
    getPastConnectionType,
    postPastConnectionType("yes"),
    getRemoveConnection,
    postRemoveConnection("minion", "01234567891", "minion@example.com"),
    getCYANotConnected,
    postCYANotConnected
  )
}


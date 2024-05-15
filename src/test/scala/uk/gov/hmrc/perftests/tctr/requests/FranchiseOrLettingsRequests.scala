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
import io.gatling.core.session.Expression
import io.gatling.http.Predef._
import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.conf.HttpConfiguration
import uk.gov.hmrc.perftests.tctr.config.servicesConfig
import utils.DateUtils._

object FranchiseOrLettingsRequests extends HttpConfiguration with servicesConfig {

  val getFranchiseOrLettingsTiedToProperty: HttpRequestBuilder =
    http("[GET] get franchise or lettings tied to property")
      .get(s"$baseUrl/$route/franchise-or-lettings-tied-to-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFranchiseOrLettingsTiedToProperty(option: String): HttpRequestBuilder =
    http("[POST] post franchise or lettings tied to property")
      .post(s"$baseUrl/$route/franchise-or-lettings-tied-to-property")
      .formParam("franchiseOrLettingsTiedToProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getConcessionsOrFranchise: HttpRequestBuilder =
    http("[GET] get concessions or franchise page")
      .get(s"$baseUrl/$route/concession-or-franchise")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postConcessionsOrFranchise(option: String): HttpRequestBuilder =
    http("[POST] post concessions or franchise page")
      .post(s"$baseUrl/$route/concession-or-franchise")
      .formParam("concessionOrFranchise", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getCateringOperationOrLettingAccommodation: HttpRequestBuilder =
    http("[GET] get catering operation or lettting accommodation page")
      .get(s"$baseUrl/$route/catering-operation-or-letting-accommodation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCateringOperationOrLettingAccommodation(option: String): HttpRequestBuilder =
    http("[POST] post catering operation or letting accommodation page")
      .post(s"$baseUrl/$route/catering-operation-or-letting-accommodation")
      .formParam("cateringOperationOrLettingAccommodation", option)
      .formParam("from", "")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCateringOperationDetails: HttpRequestBuilder =
    http("[GET] get catering operation details")
      .get(s"$baseUrl/$route/catering-operation-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCateringOperationDetails(name: String, description: String, buildingNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post catering operation details")
      .post(s"$baseUrl/$route/catering-operation-details")
      .formParamMap(Map(
        "operatorName" -> name,
        "typeOfBusiness" -> description,
        "cateringAddress.buildingNameNumber" -> buildingNumber,
        "cateringAddress.town" -> town,
        "cateringAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def getCateringOperationRent(index: Int): HttpRequestBuilder = {
      http("[GET] get catering operation rent page")
        .get(s"$baseUrl/$route/catering-operation-rent")
        .queryParam("idx", index.toString)
        .check(status.is(200))
        .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
  }

  def postCateringOperationRent(index: Int, annualRent: String): HttpRequestBuilder =
    http("[POST] post catering operation rent page")
      .post(s"$baseUrl/$route/catering-operation-rent")
      .queryParam("idx", index.toString)
      .formParamMap(Map(
        "annualRent" -> annualRent,
        "dateInput.day" -> today.day,
        "dateInput.month" -> today.month,
        "dateInput.year" -> pastYear.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def getCateringOperationRentIncludes(index: Int): HttpRequestBuilder =
    http("[GET] get catering operation rent includes")
      .get(s"$baseUrl/$route/catering-operation-rent-includes")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCateringOperationRentIncludes(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post catering operation rent includes")
      .post(s"$baseUrl/$route/catering-operation-rent-includes")
      .queryParam("idx", index.toString)
      .formParam("itemsInRent[]", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getRentReceivedFrom(index: Int): HttpRequestBuilder =
    http("[GET] get catering operation rent includes")
      .get(s"$baseUrl/$route/rent-received-from")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentReceivedFrom(index: Int, rent: String, option:String): HttpRequestBuilder =
    http("[POST] post catering operation rent includes")
      .post(s"$baseUrl/$route/rent-received-from")
      .queryParam("idx", index.toString)
      .formParam("annualRent", rent)
      .formParam("declaration", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getCalculatingTheRent(index: Int): HttpRequestBuilder =
    http("[GET] get calculating the rent page")
      .get(s"$baseUrl/$route/calculating-the-rent-for")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCalculatingTheRent(index: Int, rentDetails: String ): HttpRequestBuilder =
    http("[POST] post calculating the rent page")
      .post(s"$baseUrl/$route/calculating-the-rent-for")
      .queryParam("idx", index.toString)
      .formParamMap(Map(
        "rentDetails" -> rentDetails,
        "dateInput.day" -> pastDay.day,
        "dateInput.month" -> pastDay.month,
        "dateInput.year" -> pastDay.year,
        "csrfToken" -> f"$${csrfToken}"))
      .check(status.is(303))

  def getAddAnotherCateringOperation(index: Int): HttpRequestBuilder =
    http("[GET] get add another catering operation page")
      .get(s"$baseUrl/$route/add-another-catering-operation")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherCateringOperation(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post add another catering operation page")
      .post(s"$baseUrl/$route/add-another-catering-operation")
      .queryParam("idx", index.toString)
      .formParam("addAnotherCateringOperation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getRemoveCateringOperation(index: Int) : HttpRequestBuilder =
    http("[GET] get remove catering operation page")
      .get(s"$baseUrl/$route/remove-catering-operation")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveCateringOperation(index: Int, option: String) : HttpRequestBuilder =
    http("[POST] post remove catering operation page")
      .post(s"$baseUrl/$route/remove-catering-operation")
      .queryParam("idx", index.toString)
      .formParam("genericRemoveConfirmation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getLettingOtherPartOfProperty: HttpRequestBuilder =
    http("[GET] get letting other part of property")
      .get(s"$baseUrl/$route/letting-other-part-of-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfProperty(option: String): HttpRequestBuilder =
    http("[POST] post letting other part of property")
      .post(s"$baseUrl/$route/letting-other-part-of-property")
      .formParam("lettingOtherPartOfProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getLettingOtherPartOfPropertyDetails(index: Int): HttpRequestBuilder =
    http("[GET] get letting other part of property page")
      .get(s"$baseUrl/$route/letting-other-part-of-property-details")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyDetails(index: Int, name: String, descriptionOfBusiness: String, buildingNameNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post letting other part of property page")
      .post(s"$baseUrl/$route/letting-other-part-of-property-details")
      .queryParam("idx", index.toString)
      .formParamMap(Map(
        "lettingOperatorName" -> name,
        "lettingTypeOfBusiness" -> descriptionOfBusiness,
        "lettingAddress.buildingNameNumber" -> buildingNameNumber,
        "lettingAddress.town" -> town,
        "lettingAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def getLettingOtherPartOfPropertyRent(index: Int): HttpRequestBuilder =
    http("[GET] get letting other part of property rent page")
      .get(s"$baseUrl/$route/letting-other-part-of-property-rent")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyRent(index: Int, rent: String): HttpRequestBuilder =
    http("[POST] post letting other part of property rent page")
      .post(s"$baseUrl/$route/letting-other-part-of-property-rent")
      .queryParam("idx", index.toString)
      .formParamMap(Map(
        "annualRent" -> rent,
        "dateInput.day" -> today.day,
        "dateInput.month" -> today.month,
        "dateInput.year" -> pastYear.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def postLettingOtherPartOfPropertyRentFor6015(index: Int, rent: String): HttpRequestBuilder =
    http("[POST] post letting other part of property rent page")
      .post(s"$baseUrl/$route/letting-other-part-of-property-rent")
      .queryParam("idx", index.toString)
      .formParamMap(Map(
        "annualRent" -> rent,
        "dateInput.day" -> today.day,
        "dateInput.month" -> today.month,
        "dateInput.year" -> pastYear.year,
        "declaration" -> true,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  def getLettingOtherPartOfPropertyCheckbox(index: Int): HttpRequestBuilder =
    http("[GET] get letting other part of property checkbox")
      .get(s"$baseUrl/$route/letting-other-part-of-property-checkbox")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyCheckbox(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post letting other part of property checkbox")
      .post(s"$baseUrl/$route/letting-other-part-of-property-checkbox")
      .queryParam("idx", index.toString)
      .formParam("itemsInRent[]", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getAddAnotherLettingOtherPartOfProperty(index: Int): HttpRequestBuilder =
    http("[GET] get add another letting other part of property")
      .get(s"$baseUrl/$route/add-another-letting-other-part-of-property")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherLettingOtherPartOfProperty(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post add another letting other part of property")
      .post(s"$baseUrl/$route/add-another-letting-other-part-of-property")
      .queryParam("idx", index.toString)
      .formParam("addAnotherLettingOtherPartOfProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def getRemoveLettingOtherPartOfProperty(index: Int): HttpRequestBuilder =
    http("[GET] get remove catering operation page")
      .get(s"$baseUrl/$route/remove-letting-other-part-of-property")
      .queryParam("idx", index.toString)
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveLettingOtherPartOfProperty(index: Int, option: String): HttpRequestBuilder =
    http("[POST] post remove catering operation page")
      .post(s"$baseUrl/$route/remove-catering-operation")
      .queryParam("idx", index.toString)
      .formParam("genericRemoveConfirmation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYAAboutFranchiseOrLettings: HttpRequestBuilder =
    http("[GET] get cya for franchise or lettings page")
      .get(s"$baseUrl/$route/check-your-answers-about-franchise-or-lettings")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAAboutFranchiseOrLettings(option: String): HttpRequestBuilder =
    http("[POST] post cya for franchise or lettings page" )
      .post(s"$baseUrl/$route/check-your-answers-about-franchise-or-lettings")
      .formParam("checkYourAnswersAboutFranchiseOrLettings", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val franchiseOrLettingsSection: Seq[HttpRequestBuilder] = Seq(
    getFranchiseOrLettingsTiedToProperty,
    postFranchiseOrLettingsTiedToProperty("yes"),
    getCateringOperationOrLettingAccommodation,
    postCateringOperationOrLettingAccommodation("yes"),
    getCateringOperationDetails,
    postCateringOperationDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getCateringOperationRent(0),
    postCateringOperationRent(0, "1234"),
    getCateringOperationRentIncludes(0),
    postCateringOperationRentIncludes(0, "rates"),
    getAddAnotherCateringOperation(0),
    postAddAnotherCateringOperation(0, "no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails(0),
    postLettingOtherPartOfPropertyDetails(0, "Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent(0),
    postLettingOtherPartOfPropertyRent(0, "12345"),
    getLettingOtherPartOfPropertyCheckbox(0),
    postLettingOtherPartOfPropertyCheckbox(0, "rates"),
    getAddAnotherLettingOtherPartOfProperty(0),
    postAddAnotherLettingOtherPartOfProperty(0, "no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes")
  )

  val franchiseOrLettingsSectionFor6015: Seq[HttpRequestBuilder] = Seq(
    getFranchiseOrLettingsTiedToProperty,
    postFranchiseOrLettingsTiedToProperty("yes"),
    getConcessionsOrFranchise,
    postConcessionsOrFranchise("yes"),
    getCateringOperationDetails,
    postCateringOperationDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getRentReceivedFrom(0),
    postRentReceivedFrom(0, "1234", "true"),
    getCalculatingTheRent(0),
    postCalculatingTheRent(0, "rent details"),
    getCateringOperationRentIncludes(0),
    postCateringOperationRentIncludes(0, "rates"),
    getAddAnotherCateringOperation(0),
    getRemoveCateringOperation(0),
    postRemoveCateringOperation(0, "no"),
    postAddAnotherCateringOperation(0, "no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails(0),
    postLettingOtherPartOfPropertyDetails(0, "Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent(0),
    postLettingOtherPartOfPropertyRentFor6015(0, "12345"),
    getLettingOtherPartOfPropertyCheckbox(0),
    postLettingOtherPartOfPropertyCheckbox(0, "rates"),
    getAddAnotherLettingOtherPartOfProperty(0),
    getRemoveLettingOtherPartOfProperty(0),
    postRemoveLettingOtherPartOfProperty(0, "no"),
    postAddAnotherLettingOtherPartOfProperty(0, "no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes")
  )

}

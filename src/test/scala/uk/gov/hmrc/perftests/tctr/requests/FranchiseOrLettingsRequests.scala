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

  val getTypeOfLetting: HttpRequestBuilder =
    http("[GET] get type of letting")
      .get(s"$baseUrl/$route/type-of-letting")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTypeOfLetting(option: String): HttpRequestBuilder =
    http("[POST] post type of letting page")
      .post(s"$baseUrl/$route/type-of-letting")
      .formParam("typeOfLetting", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAtmLetting: HttpRequestBuilder =
    http("[GET] get atm letting page")
      .get(s"$baseUrl/$route/atm-letting")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAtmLetting(bank: String, buildingNameNumber:String, town: String, postcode: String) : HttpRequestBuilder =
    http("[GET] get atm letting page")
      .post(s"$baseUrl/$route/atm-letting")
      .formParamMap(Map(
        "bankOrCompany" -> bank,
        "correspondenceAddress.buildingNameNumber" -> buildingNameNumber,
        "correspondenceAddress.town" -> town,
        "correspondenceAddress.postcode" -> postcode,
        "csrfToken"-> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getConcessionOrFranchiseFee : HttpRequestBuilder =
    http("[GET] get concession or franchise fee page")
      .get(s"$baseUrl/$route/concession-or-franchise-fee")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
  def postConcessionOrFranchiseFee(option: String): HttpRequestBuilder =
    http("[POST] post concession or franchise fee page")
      .post(s"$baseUrl/$route/concession-or-franchise-fee")
      .formParam("concessionOrFranchiseFee", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getRentDetails: HttpRequestBuilder =
    http("[GET] get rent details page")
      .get(s"$baseUrl/$route/rent-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentDetails(rent: String): HttpRequestBuilder =
    http("[POST] post rent details page")
      .post(s"$baseUrl/$route/rent-details")
      .formParamMap(Map(
        "annualRent" -> rent,
        "dateInput.day" -> today.day,
        "dateInput.month" -> today.month,
        "dateInput.year" -> today.year,
        "csrfToken"-> f"$${csrfToken}"
      ))
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

  val getCateringOperationBusinessDetails: HttpRequestBuilder =
    http("[GET] get catering operation business details")
      .get(s"$baseUrl/$route/catering-operation-business-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCateringOperationBusinessDetails(name: String, description: String, propertyUse: String): HttpRequestBuilder =
    http("[POST] post catering operation business details")
      .post(s"$baseUrl/$route/catering-operation-business-details")
      .formParamMap(Map(
        "operatorName6030" -> name,
        "typeOfBusiness" -> description,
        "howBusinessPropertyIsUsedr" -> propertyUse,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getFeeReceived: HttpRequestBuilder =
    http("s[GET] get fee received page")
      .get(s"$baseUrl/$route/fee-received")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFeeReceived(feeReceivedPerYear:String, feeReceived: String, feeDetails:String) : HttpRequestBuilder =
    http("[POST] post fee received page")
      .post(s"$baseUrl/$route/fee-received")
      .formParam("feeReceivedPerYear.year[0].tradingPeriod", feeReceivedPerYear)
      .formParam("feeReceivedPerYear.year[0].concessionOrFranchiseFee", feeReceived)
      .formParam("feeCalculationDetails", feeDetails)
      .formParam( "csrfToken", f"$${csrfToken}")
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

  val getLettingOtherPartOfPropertyDetails : HttpRequestBuilder =
    http("[GET] get letting other part of property page")
      .get(s"$baseUrl/$route/letting-other-part-of-property-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyDetails(name: String, descriptionOfBusiness: String, buildingNameNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post letting other part of property page")
      .post(s"$baseUrl/$route/letting-other-part-of-property-details")
      .formParamMap(Map(
        "lettingOperatorName" -> name,
        "lettingTypeOfBusiness" -> descriptionOfBusiness,
        "lettingAddress.buildingNameNumber" -> buildingNameNumber,
        "lettingAddress.town" -> town,
        "lettingAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getLettingOtherPartOfPropertyRent: HttpRequestBuilder =
    http("[GET] get letting other part of property rent page")
      .get(s"$baseUrl/$route/letting-other-part-of-property-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyRent(rent: String): HttpRequestBuilder =
    http("[POST] post letting other part of property rent page")
      .post(s"$baseUrl/$route/letting-other-part-of-property-rent")
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

  val getLettingOtherPartOfPropertyCheckbox: HttpRequestBuilder =
    http("[GET] get letting other part of property checkbox")
      .get(s"$baseUrl/$route/letting-other-part-of-property-checkbox")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLettingOtherPartOfPropertyCheckbox(option: String): HttpRequestBuilder =
    http("[POST] post letting other part of property checkbox")
      .post(s"$baseUrl/$route/letting-other-part-of-property-checkbox")
      .formParam("itemsInRent[]", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAddAnotherLettingOtherPartOfProperty: HttpRequestBuilder =
    http("[GET] get add another letting other part of property")
      .get(s"$baseUrl/$route/add-another-letting-other-part-of-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherLettingOtherPartOfProperty(option: String): HttpRequestBuilder =
    http("[POST] post add another letting other part of property")
      .post(s"$baseUrl/$route/add-another-letting-other-part-of-property")
      .formParam("addAnotherLettingOtherPartOfProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAddAnotherLetting: HttpRequestBuilder =
    http("[GET] get add another letting page")
      .get(s"$baseUrl/$route/add-another-letting")
        .check(status.is(200))
        .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherLetting(option: String): HttpRequestBuilder =
    http("[POST] post add another letting page")
      .post(s"$baseUrl/$route/add-another-letting")
      .formParam("addAnotherLetting", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAddAnotherCateringOperation: HttpRequestBuilder =
    http("[GET] get add another catering operation page")
      .get(s"$baseUrl/$route/add-another-catering-operation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAddAnotherCateringOperation(option: String): HttpRequestBuilder =
    http("[POST] post add another catering operation page")
      .post(s"$baseUrl/$route/add-another-catering-operation")
      .formParam("addAnotherCateringOperation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRemoveCateringOperation: HttpRequestBuilder =
    http("[GET] get remove catering operation page")
      .get(s"$baseUrl/$route/remove-catering-operation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveCateringOperation(option: String): HttpRequestBuilder =
    http("[POST] post remove catering operation page")
      .post(s"$baseUrl/$route/remove-catering-operation")
      .formParam("genericRemoveConfirmation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRemoveLettingOtherPartOfProperty: HttpRequestBuilder =
    http("[GET] get remove catering operation page")
      .get(s"$baseUrl/$route/remove-letting-other-part-of-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRemoveLettingOtherPartOfProperty(option: String): HttpRequestBuilder =
    http("[POST] post remove catering operation page")
      .post(s"$baseUrl/$route/remove-catering-operation")
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
    getAddAnotherCateringOperation,
    postAddAnotherCateringOperation( "no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails,
    postLettingOtherPartOfPropertyDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent,
    postLettingOtherPartOfPropertyRent("12345"),
    getLettingOtherPartOfPropertyCheckbox,
    postLettingOtherPartOfPropertyCheckbox("rates"),
    getAddAnotherLettingOtherPartOfProperty,
    postAddAnotherLettingOtherPartOfProperty("no"),
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
    getAddAnotherCateringOperation,
    getRemoveCateringOperation,
    postRemoveCateringOperation("no"),
    postAddAnotherCateringOperation( "no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails,
    postLettingOtherPartOfPropertyDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent,
    postLettingOtherPartOfPropertyRentFor6015(0, "12345"),
    getLettingOtherPartOfPropertyCheckbox,
    postLettingOtherPartOfPropertyCheckbox("rates"),
    getAddAnotherLettingOtherPartOfProperty,
    getRemoveLettingOtherPartOfProperty,
    postRemoveLettingOtherPartOfProperty("no"),
    postAddAnotherLettingOtherPartOfProperty("no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes")
  )

  val franchiseOrLettingsSectionFor6016: Seq[HttpRequestBuilder] = Seq(
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
    getAddAnotherCateringOperation,
    getRemoveCateringOperation,
    postRemoveCateringOperation("no"),
    postAddAnotherCateringOperation("no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails,
    postLettingOtherPartOfPropertyDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent,
    postLettingOtherPartOfPropertyRentFor6015(0, "12345"),
    getLettingOtherPartOfPropertyCheckbox,
    postLettingOtherPartOfPropertyCheckbox("rates"),
    getAddAnotherLettingOtherPartOfProperty,
    getRemoveLettingOtherPartOfProperty,
    postRemoveLettingOtherPartOfProperty("no"),
    postAddAnotherLettingOtherPartOfProperty("no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes"))

  val franchiseOrLettingsSectionFor6020: Seq[HttpRequestBuilder] = Seq(
    getFranchiseOrLettingsTiedToProperty,
    postFranchiseOrLettingsTiedToProperty("yes"),
    getTypeOfLetting,
    postTypeOfLetting("automatedTellerMachine"),
    getAtmLetting,
    postAtmLetting("TSB", "10 minion street", "Minion city", "BN12 4AX"),
    getRentDetails,
    postRentDetails("1234"),
    getAddAnotherLetting,
    postAddAnotherLetting("no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes"))

  val franchiseOrLettingsSectionFor6030: Seq[HttpRequestBuilder] = Seq(
    getFranchiseOrLettingsTiedToProperty,
    postFranchiseOrLettingsTiedToProperty("yes"),
    getConcessionOrFranchiseFee,
    postConcessionOrFranchiseFee("yes"),
    getCateringOperationBusinessDetails,
    postCateringOperationBusinessDetails("Dru", "Restaurant", "Cater services"),
    getFeeReceived,
    postFeeReceived("52", "1234", "fee details"),
    getAddAnotherCateringOperation,
    postAddAnotherCateringOperation("no"),
    getRemoveCateringOperation,
    postRemoveCateringOperation("no"),
    getLettingOtherPartOfProperty,
    postLettingOtherPartOfProperty("yes"),
    getLettingOtherPartOfPropertyDetails,
    postLettingOtherPartOfPropertyDetails("Minions Group", "Banana Group Ltd", "12 valley", "Despicable city", "BN12 4AX"),
    getLettingOtherPartOfPropertyRent,
    postLettingOtherPartOfPropertyRent("1234"),
    getLettingOtherPartOfPropertyCheckbox,
    postLettingOtherPartOfPropertyCheckbox("rates"),
    getAddAnotherLettingOtherPartOfProperty,
    postAddAnotherLettingOtherPartOfProperty("no"),
    getRemoveLettingOtherPartOfProperty,
    postRemoveLettingOtherPartOfProperty("no"),
    getCYAAboutFranchiseOrLettings,
    postCYAAboutFranchiseOrLettings("yes"))

}

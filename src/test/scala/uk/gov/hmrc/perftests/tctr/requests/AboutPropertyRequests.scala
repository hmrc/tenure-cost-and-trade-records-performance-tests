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

object AboutPropertyRequests extends HttpConfiguration with servicesConfig {

  val getTradingNameOwnTheProperty: HttpRequestBuilder =
    http("[GET] get trading name own the property")
      .get(s"$baseUrl/$route/trading-name-own-the-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTradingNameOwnTheProperty(option: String): HttpRequestBuilder =
    http("[POST] post trading name own the property")
      .post(s"$baseUrl/$route/trading-name-own-the-property")
      .formParam("tradingNameOwnTheProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTradingNamePayingRent: HttpRequestBuilder =
    http("[GET] get trading name paying rent page")
      .get(s"$baseUrl/$route/trading-name-paying-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPostTradingNamePayingRent(option: String): HttpRequestBuilder =
    http("[POST] post trading name paying rent page")
      .post(s"$baseUrl/$route/trading-name-paying-rent")
      .formParam("tradingNamePayingRent", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAreYouThirdParty: HttpRequestBuilder =
    http("[GET] get are you third party page")
      .get(s"$baseUrl/$route/are-you-third-party")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAreYouThirdParty(option: String): HttpRequestBuilder =
    http("[POST] post are you a third party page")
      .post(s"$baseUrl/$route/are-you-third-party")
      .formParam("areYouThirdParty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYAConnectionToTheProperty: HttpRequestBuilder =
    http("[GET] get cya connection to the property")
      .get(s"$baseUrl/$route/check-your-answers-connection-to-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAConnectionToTheProperty(option: String): HttpRequestBuilder =
    http("[POST post cya connection to the property]")
      .post(s"$baseUrl/$route/check-your-answers-connection-to-property")
      .formParam("checkYourAnswersConnectionToProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAboutYouPage: HttpRequestBuilder =
    http("[GET] get about you page")
      .get(s"$baseUrl/$route/about-you")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAboutYouPage(name: String, phone: String, email: String): HttpRequestBuilder =
    http("[POST] post about you page")
      .post(s"$baseUrl/$route/about-you")
      .formParam("fullName", name)
      .formParam("contactDetails.phone", phone)
      .formParam("contactDetails.email", email)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAboutTheProperty: HttpRequestBuilder =
    http("[GET] get about the property page")
      .get(s"$baseUrl/$route/about-the-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAboutThePropertyDescription: HttpRequestBuilder =
    http("[GET] get about the property description")
      .get(s"$baseUrl/$route/about-the-property-description")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAboutThePropertyDescription(answer: String): HttpRequestBuilder =
    http("[POST] post about the property description")
      .post(s"$baseUrl/$route/about-the-property-description")
      .formParam("propertyCurrentlyUsedString", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  def postAboutTheProperty(option: String): HttpRequestBuilder =
    http("[POST] post about the property page")
      .post(s"$baseUrl/$route/about-the-property")
      .formParam("propertyCurrentlyUsed", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAboutThePropertyFor6016(option: String): HttpRequestBuilder =
    http("[POST] post about the property page")
      .post(s"$baseUrl/$route/about-the-property")
      .formParam("propertyCurrentlyUsed", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getContactDetailsQuestion: HttpRequestBuilder =
    http("[GET] get contact details question page")
      .get(s"$baseUrl/$route/contact-details-question")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postContactDetailsQuestion(option: String): HttpRequestBuilder =
    http("[POST] contact details question page")
      .post(s"$baseUrl/$route/contact-details-question")
      .formParam("contactDetailsQuestion", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAlternateContactDetails: HttpRequestBuilder =
    http("[GET] get alternate contact details page")
      .get(s"$baseUrl/$route/alternate-contact-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAlternateContactDetails(buildingNameNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post alternate contact details page")
      .post(s"$baseUrl/$route/alternate-contact-details")
      .formParamMap(Map(
        "alternativeContactAddress.buildingNameNumber" -> buildingNameNumber,
        "alternativeContactAddress.town" -> town,
        "alternativeContactAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getRenewablesPlants: HttpRequestBuilder =
    http("[GET] get renewables plants page")
      .get(s"$baseUrl/$route/renewables-plants")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRenewablesPlants(option: String): HttpRequestBuilder =
    http("[POST] post renewables plants page")
      .post(s"$baseUrl/$route/renewables-plants")
      .formParam("renewablesPlant", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getThreeYearsConstructed: HttpRequestBuilder =
    http("[GET] get three years constructed page")
      .get(s"$baseUrl/$route/three-years-constructed")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postThreeYearsConstructed(option: String): HttpRequestBuilder =
    http("[POST] post three years constructed page")
      .post(s"$baseUrl/$route/renewables-plants")
      .formParam("threeYearsConstructed", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCostsBreakdown: HttpRequestBuilder =
    http("[GET] get costs breakdown page")
      .get(s"$baseUrl/$route/costs-breakdown")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCostsBreakdown(details: String): HttpRequestBuilder =
    http("[POST] post costs breakdown page")
      .post(s"$baseUrl/$route/costs-breakdown")
      .formParam("costsBreakdown", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPlantAndTechnology: HttpRequestBuilder =
    http("[GET] get plant and technology page")
      .get(s"$baseUrl/$route/plant-and-technology")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPlantAndTechnology(details: String): HttpRequestBuilder =
    http("[POST] post plant and technology page")
      .post(s"$baseUrl/$route/plant-and-technology")
      .formParam("plantAndTechnology", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getGeneratorCapacity: HttpRequestBuilder =
    http("[GET] get generator capacity page")
      .get(s"$baseUrl/$route/generator-capacity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postGeneratorCapacity(capacity: String): HttpRequestBuilder =
    http("[POST] get generator capacity page")
      .post(s"$baseUrl/$route/generator-capacity")
      .formParam("generatorCapacity", capacity)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))




  val getWebsiteForProperty: HttpRequestBuilder =
    http("[GET] get website for the property")
      .get(s"$baseUrl/$route/website-for-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWebsiteForProperty(option: String, answer: String): HttpRequestBuilder =
    http("[POST] post website for the property")
      .post(s"$baseUrl/$route/website-for-property")
      .formParam("buildingOperatingHaveAWebsite", option)
      .formParam("websiteAddressForProperty", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCharityQuestion: HttpRequestBuilder =
    http("[GET] get charity question page")
      .get(s"$baseUrl/$route/charity-question")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCharityQuestion(option: String): HttpRequestBuilder =
    http("[POST] post charity question page")
      .post(s"$baseUrl/$route/charity-question")
      .formParam("charityQuestion", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTradingActivity: HttpRequestBuilder =
    http("[GET] get trading activity page")
      .get(s"$baseUrl/$route/trading-activity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTradingActivity(answer: String, option: String): HttpRequestBuilder =
    http("[POST] post trading activity page")
      .post(s"$baseUrl/$route/trading-activity")
      .formParam("tradingActivityQuestion", option)
      .formParam("tradingActivityDetails", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getLicensableActivities: HttpRequestBuilder =
    http("[GET] get licensable activities page")
      .get(s"$baseUrl/$route/licensable-activities")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
  def postLicensableActivities(option: String): HttpRequestBuilder =
    http("[POST] post licensable activities page")
      .post(s"$baseUrl/$route/licensable-activities")
      .formParam("licensableActivities", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPremisesLicenseGranted: HttpRequestBuilder =
    http("[GET] get premises license granted page")
      .get(s"$baseUrl/$route/premises-license-granted")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPremisesLicenseGranted(Option: String): HttpRequestBuilder =
    http("[POST] post premises license granted page")
      .post(s"$baseUrl/$route/premises-license-granted")
      .formParam("premisesLicenseGranted", Option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPremisesLicenseGrantedDetails: HttpRequestBuilder =
    http("[GET] get premises license granted details")
      .get(s"$baseUrl/$route/premises-license-granted-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPremisesLicenseGrantedDetails(option: String): HttpRequestBuilder =
    http("[POST] post premises license granted details")
      .post(s"$baseUrl/$route/premises-license-granted-details")
      .formParam("premisesLicenseGrantedInformation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLicensableActivitiesDetails: HttpRequestBuilder =
    http("[GET] get licensable activities details")
      .get(s"$baseUrl/$route/licensable-activities-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLicensableActivitiesDetails(details: String): HttpRequestBuilder =
    http("[POST] post get licensable activities details")
      .post(s"$baseUrl/$route/licensable-activities-details")
      .formParam("licensableActivitiesDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPremisesLicenseConditions: HttpRequestBuilder =
    http("[GET] get premises license conditions")
      .get(s"$baseUrl/$route/premises-license-conditions")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPremisesLicenseConditions(option: String): HttpRequestBuilder =
    http("[POST] post premises license conditions")
      .post(s"$baseUrl/$route/premises-license-conditions")
      .formParam("premisesLicenseConditions", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPremisesLicenseConditionsDetails: HttpRequestBuilder =
    http("[GET] get premises license conditions details")
      .get(s"$baseUrl/$route/premises-license-conditions-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPremisesLicenseConditionsDetails(option: String): HttpRequestBuilder =
    http("[POST] post premises license conditions details")
      .post(s"$baseUrl/$route/premises-license-conditions-details")
      .formParam("premisesLicenseConditionsDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getEnforcementActionBeenTaken: HttpRequestBuilder =
    http("[GET] get enforcement action been taken")
      .get(s"$baseUrl/$route/enforcement-action-been-taken")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postEnforcementActionBeenTaken(option: String): HttpRequestBuilder =
    http("[POST] post enforcement action been taken")
      .post(s"$baseUrl/$route/enforcement-action-been-taken")
      .formParam("enforcementActionBeenTaken", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getEnforcementActionBeenTakenDetails: HttpRequestBuilder =
    http("[GET] get enforcement action been taken details")
      .get(s"$baseUrl/$route/enforcement-action-been-taken-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))


  def postEnforcementActionBeenTakenDetails(details: String): HttpRequestBuilder =
    http("[POST] post enforcement action been taken details")
      .post(s"$baseUrl/$route/enforcement-action-been-taken-details")
      .formParam("enforcementActionHasBeenTakenDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTiedForGoods: HttpRequestBuilder =
    http("[GET] get tied for goods")
      .get(s"$baseUrl/$route/tied-for-goods")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTiedForGoods(option: String): HttpRequestBuilder =
    http("[POST] post tied for goods")
      .post(s"$baseUrl/$route/tied-for-goods")
      .formParam("tiedForGoods", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTiedForGoodDetails: HttpRequestBuilder =
    http("[GET] get tied for goods details")
      .get(s"$baseUrl/$route/tied-for-goods-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTiedForGoodDetails(details: String): HttpRequestBuilder =
    http("[POST] post tied for goods details")
      .post(s"$baseUrl/$route/tied-for-goods-details")
      .formParam("tiedForGoodsDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCYAAboutTheProperty: HttpRequestBuilder =
    http("[GET] get cya about the property")
      .get(s"$baseUrl/$route/check-your-answers-about-the-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAAboutTheProperty(option: String): HttpRequestBuilder =
    http("[POST] post cya about the property")
      .post(s"$baseUrl/$route/check-your-answers-about-the-property")
      .formParam("checkYourAnswersAboutTheProperty", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def aboutYouAndPropertySection(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getVacantPropertiesPage,
    postVacantProperties("no"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getTaskListPage,
    getAboutYouPage,
    postAboutYouPage("minion", "01234567899", "minion@example.com"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getAboutTheProperty,
    postAboutTheProperty("publicHouse"),
    getWebsiteForProperty,
    postWebsiteForProperty("yes", "www.ertyu.com"),
    getLicensableActivities,
    postLicensableActivities("yes"),
    getLicensableActivitiesDetails,
    postLicensableActivitiesDetails("Licensable Activities Details"),
    getPremisesLicenseConditions,
    postPremisesLicenseConditions("yes"),
    getPremisesLicenseConditionsDetails,
    postPremisesLicenseConditionsDetails("Premises License conditions details"),
    getEnforcementActionBeenTaken,
    postEnforcementActionBeenTaken("yes"),
    getEnforcementActionBeenTakenDetails,
    postEnforcementActionBeenTakenDetails("Enforcement action been taken details"),
    getTiedForGoods,
    postTiedForGoods("yes"),
    getTiedForGoodDetails,
    postTiedForGoodDetails("fullTie"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )

  def aboutYouAndPropertySection6015(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getVacantPropertiesPage,
    postVacantProperties("no"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getTaskListPage,
    getAboutYouPage,
    postAboutYouPage("minion", "01234567899", "minion@example.com"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getAboutTheProperty,
    postAboutTheProperty("publicHouse"),
    getWebsiteForProperty,
    postWebsiteForProperty("yes", "www.ertyu.com"),
    getPremisesLicenseGranted,
    postPremisesLicenseGranted("yes"),
    getPremisesLicenseGrantedDetails,
    postPremisesLicenseGrantedDetails("Details"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )
  def aboutYouAndPropertySection6016(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getVacantPropertiesPage,
    postVacantProperties("no"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getAboutYouPage,
    postAboutYouPage("minion", "01234567899", "minion@example.com"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getAboutTheProperty,
    postAboutThePropertyFor6016("hotel"),
    getWebsiteForProperty,
    postWebsiteForProperty("yes", "www.ertyu.com"),
    getPremisesLicenseGranted,
    postPremisesLicenseGranted("yes"),
    getPremisesLicenseGrantedDetails,
    postPremisesLicenseGrantedDetails("Details"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )

  def aboutYouAndPropertySection6020(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getVacantPropertiesPage,
    postVacantProperties("no"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getAboutYouPage,
    postAboutYouPage("minion", "01234567899", "minion@example.com"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getAboutThePropertyDescription,
    postAboutThePropertyDescription("hotel"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )

  def aboutYouAndPropertySection6030(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getVacantPropertiesPage,
    postVacantProperties("no"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getAboutTheProperty,
    postAboutTheProperty("restaurant"),
    getWebsiteForProperty,
    postWebsiteForProperty("yes","www.example.com"),
    getCharityQuestion,
    postCharityQuestion("yes"),
    getTradingActivity,
    postTradingActivity("yes", "catering services"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )

  def aboutYouAndPropertySection6076(form: String): Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
    postLoginPage("BN12 4AX", form),
    getAreYouStillConnectedPage,
    postAreYouStillConnectedPage("yes"),
    getNameOfOperatorFromProperty,
    postNameOfOperatorFromProperty("Dru"),
    getTradingNameOwnTheProperty,
    postTradingNameOwnTheProperty("no"),
    getTradingNamePayingRent,
    postPostTradingNamePayingRent("yes"),
    getAreYouThirdParty,
    postAreYouThirdParty("yes"),
    getCYAConnectionToTheProperty,
    postCYAConnectionToTheProperty("yes"),
    getAboutYouPage,
    postAboutYouPage("minion", "01234567899", "minion@example.com"),
    getContactDetailsQuestion,
    postContactDetailsQuestion("yes"),
    getAlternateContactDetails,
    postAlternateContactDetails("10 Minion Street", "MinionsCity", "BN12 4AX"),
    getRenewablesPlants,
    postRenewablesPlants("intermittent"),
    getThreeYearsConstructed,
    postThreeYearsConstructed("yes"),
    getCostsBreakdown,
    postCostsBreakdown("costs breakdown details"),
    getPlantAndTechnology,
    postPlantAndTechnology("plant and technology name"),
    getGeneratorCapacity,
    postGeneratorCapacity("50 MW"),
    getCYAAboutTheProperty,
    postCYAAboutTheProperty("yes")
  )

}

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
        "currentRentFirstPaid.day" -> pastMonth.day,
        "currentRentFirstPaid.month" -> today.month,
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

  val getIncludedInYourRent: HttpRequestBuilder =
    http("[GET] get included in your rent page")
      .get(s"$baseUrl/$route/included-in-your-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIncludedInYourRent(option: String): HttpRequestBuilder =
    http("[POST] post included in your rent page")
      .post(s"$baseUrl/$route/included-in-your-rent")
      .formParam("includedInYourRent[]", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getDoesTheRentPayable: HttpRequestBuilder =
    http("[GET] get does the rent payable")
      .get(s"$baseUrl/$route/does-the-rent-payable")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postDoesRentPayable(option1: String, option2: String): HttpRequestBuilder =
    http("[POST] post does the rent payable page")
      .post(s"$baseUrl/$route/does-the-rent-payable")
      .formParam("rentPayable[]", option1)
      .formParam("rentPayable[]", option2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getUltimatelyResponsible: HttpRequestBuilder =
    http("[GET] get ultimately responsible page")
      .get(s"$baseUrl/$route/ultimately-responsible")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postUltimatelyResponsible(option1: String, option2: String, option3: String): HttpRequestBuilder =
    http("[POST] post ultimately responsible page")
      .post(s"$baseUrl/$route/ultimately-responsible")
      .formParamMap(Map(
        "outsideRepairs" -> option1,
        "insideRepairs" -> option2,
        "buildingInsurance" -> option3,
        "sharedResponsibilities" -> "shared responsibilities",
        "continue_button" -> "continue_button",
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getRentIncludeTradeServices: HttpRequestBuilder =
    http("[GET] get rent include trade services")
      .get(s"$baseUrl/$route/rent-include-trade-services")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludeTradeServices(option: String): HttpRequestBuilder =
    http("[POST] post rent include trade services")
      .post(s"$baseUrl/$route/rent-include-trade-services")
      .formParam("rentIncludeTradeServices", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentIncludeTradeServicesDetails: HttpRequestBuilder =
    http("[GET] get rent include trade services details")
      .get(s"$baseUrl/$route/rent-include-trade-services-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludeTradeServiceDetails(sum: String, services: String): HttpRequestBuilder =
    http("[POST] post rent include trade services details ")
      .post(s"$baseUrl/$route/rent-include-trade-services-details")
      .formParam("sumIncludedInRent", sum)
      .formParam("describeServices", services)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentIncludeFixturesAndFittings: HttpRequestBuilder =
    http("[GET] get rent include fixtures and fittings")
      .get(s"$baseUrl/$route/rent-include-fixtures-and-fittings")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludeFixturesAndFittings(option: String): HttpRequestBuilder =
    http("[POST] post rent includes fixtures and fittings")
      .post(s"$baseUrl/$route/rent-include-fixtures-and-fittings")
      .formParam("rentIncludeFixturesAndFittings", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getRentIncludeFixturesAndFittingsDetails: HttpRequestBuilder =
    http("[GET] get rent includes fixtures and fittings details")
      .get(s"$baseUrl/$route/rent-include-fixtures-and-fittings-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludeFixturesAndFittingsDetails(rent: String): HttpRequestBuilder =
    http("[POST] post rent includes fixtures and fittings details")
      .post(s"$baseUrl/$route/rent-include-fixtures-and-fittings-details")
      .formParam("rentIncludeFixturesAndFittingsDetails", rent)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentOpenMarketValue: HttpRequestBuilder =
    http("[GET] get rent open market value")
      .get(s"$baseUrl/$route/rent-open-market-value")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentOpenMarketValue(option: String): HttpRequestBuilder =
    http("[POST] post rent open market value")
      .post(s"$baseUrl/$route/rent-open-market-value")
      .formParam("rentOpenMarketValue", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentIncreaseAnnuallyWithRpi: HttpRequestBuilder =
    http("[GET] get rent increased annually with rpi page")
      .get(s"$baseUrl/$route/rent-increase-annually-with-rpi")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncreaseAnnuallyWithRpi(option: String): HttpRequestBuilder =
    http("[POST] post rent increased annually with rpi page")
      .post(s"$baseUrl/$route/rent-increase-annually-with-rpi")
      .formParam("rentIncreasedAnnuallyWithRPIs", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentPayableVaryAccordingToGrossOrNetDetails: HttpRequestBuilder =
    http("[GET] get rent payable vary according to gross or net details page")
      .get(s"$baseUrl/$route/rent-payable-vary-according-to-gross-or-net-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))


  def postRentPayableVaryAccordingToGrossOrNetDetails(details: String): HttpRequestBuilder =
    http("[POST] post rent payable vary according to gross or net details page")
      .post(s"$baseUrl/$route/rent-payable-vary-according-to-gross-or-net-details")
      .formParam("rentPayableVaryAccordingToGrossOrNetDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentPayableVaryOnQuantityOfBeers: HttpRequestBuilder =
    http("[GET] get rent payable vary on quantity of beers")
      .get(s"$baseUrl/$route/rent-payable-vary-on-quantity-of-beers")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentPayableVaryOnQuantityOfBeers(option: String): HttpRequestBuilder =
    http("[POST] post rent payable vary on quantity of beers")
      .post(s"$baseUrl/$route/rent-payable-vary-on-quantity-of-beers")
      .formParam("rentPayableVaryOnQuantityOfBeers", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentPayableVaryOnQuantityOfBeersDetails: HttpRequestBuilder =
    http("[GET] get rent payable vary on quantity of beers details")
      .get(s"$baseUrl/$route/rent-payable-vary-on-quantity-of-beers-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentPayableVaryOnQuantityOfBeersDetails(details: String): HttpRequestBuilder =
    http("[POST] post rent payable vary on quantity of beers details")
      .post(s"$baseUrl/$route/rent-payable-vary-on-quantity-of-beers-details")
      .formParam("rentPayableVaryOnQuantityOfBeersDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getHowCurrentRentIsFixed: HttpRequestBuilder =
    http("[GET] get how current rent is fixed page")
      .get(s"$baseUrl/$route/how-is-current-rent-fixed")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postHowCurrentRentIsFixed(answer: String): HttpRequestBuilder =
    http("[POST] post how current rent is fixed page")
      .post(s"$baseUrl/$route/how-is-current-rent-fixed")
      .formParamMap(Map(
        "howIsCurrentRentFixed" -> answer,
        "rentActuallyAgreed.day" -> today.day,
        "rentActuallyAgreed.month" -> today.month,
        "rentActuallyAgreed.year" -> pastYear.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getMethodToFixCurrentRent : HttpRequestBuilder =
    http("[GET] get method to fix current rent")
      .get(s"$baseUrl/$route/method-to-fix-current-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postMethodToFixCurrentRent(method: String): HttpRequestBuilder =
    http("[POST] post method to fix current rent")
      .post(s"$baseUrl/$route/method-to-fix-current-rent")
      .formParam("methodUsedToFixCurrentRent", method)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIntervalsOfRentReview: HttpRequestBuilder =
    http("[GET] get intervals of rent review")
      .get(s"$baseUrl/$route/intervals-of-rent-review")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIntervalsOfRentReview(details: String): HttpRequestBuilder =
    http("[POST] post intervals of rent review")
      .post(s"$baseUrl/$route/intervals-of-rent-review")
      .formParamMap(Map(
        "intervalsOfRentReview" -> details,
        "nextReview.day" -> today.day,
        "nextReview.month" -> today.month,
        "nextReview.year" -> nextYear.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCanRentBeReducedOnReview: HttpRequestBuilder =
    http("[GET] get can rent be reduced on review page")
      .get(s"$baseUrl/$route/can-rent-be-reduced-on-review")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCanRentBeReducedOnReview(option: String): HttpRequestBuilder =
    http("[POST] post can rent be reduced on review pag")
      .post(s"$baseUrl/$route/can-rent-be-reduced-on-review")
      .formParam("canRentBeReducedOnReview", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFormerLeaseSurrendered: HttpRequestBuilder =
    http("[GET] get former lease surrendered page")
      .get(s"$baseUrl/$route/former-lease-surrendered")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFormerLeaseSurrendered(option: String): HttpRequestBuilder =
    http("[POST] post former lease surrendered page")
      .post(s"$baseUrl/$route/former-lease-surrendered")
      .formParam("formerLeaseSurrendered", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTenantsAdditionsDisregarded: HttpRequestBuilder =
    http("[GET] get tenants additions disregarded page")
      .get(s"$baseUrl/$route/tenants-additions-disregarded")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTenantsAdditionsDisregarded(option: String): HttpRequestBuilder =
    http("[POST] post tenants additions disregarded page")
      .post(s"$baseUrl/$route/tenants-additions-disregarded")
      .formParam("tenantsAdditionsDisregarded", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTenantsAdditionsDisregardedDetails: HttpRequestBuilder =
    http("[GET] get tenants additions disregarded details page")
      .get(s"$baseUrl/$route/tenants-additions-disregarded-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTenantsAdditionsDisregardedDetails(details: String): HttpRequestBuilder =
    http("[POST] post tenants additions disregarded details page")
      .post(s"$baseUrl/$route/tenants-additions-disregarded-details")
      .formParam("tenantsAdditionsDisregardedDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPayACapitalSum : HttpRequestBuilder =
    http("[GET] get pay a capital sum page")
      .get(s"$baseUrl/$route/pay-a-capital-sum")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def PostPayACapitalSum(option: String) : HttpRequestBuilder =
    http("[POST] post pay a capital sum page")
      .post(s"$baseUrl/$route/pay-a-capital-sum")
      .formParam("payACapitalSum", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getReceivePaymentWhenLeaseGranted : HttpRequestBuilder =
    http("[GET] get receive payment when lease granted page")
      .get(s"$baseUrl/$route/receive-payment-when-lease-granted")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postReceivePaymentWhenLeaseGranted(option: String) : HttpRequestBuilder =
    http("[POST] post receive payment when lease granted page")
      .post(s"$baseUrl/$route/receive-payment-when-lease-granted")
      .formParam("receivePaymentWhenLeaseGranted", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLegalOrPlanningRestrictions: HttpRequestBuilder =
    http("[GET] get legal or planning restrictions page")
      .get(s"$baseUrl/$route/legal-or-planning-restrictions")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLegalOrPlanningRestrictions(option: String): HttpRequestBuilder =
    http("[POST] post legal or planning restrictions page")
      .post(s"$baseUrl/$route/legal-or-planning-restrictions")
      .formParam("legalOrPlanningRestrictions", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getLegalOrPlanningRestrictionsDetails: HttpRequestBuilder =
    http("[GET] get legal or planning restrictions details page")
      .get(s"$baseUrl/$route/legal-or-planning-restrictions-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLegalOrPlanningRestrictionsDetails(details: String): HttpRequestBuilder =
    http("[POST] post legal or planning restrictions details page")
      .post(s"$baseUrl/$route/legal-or-planning-restrictions-details")
      .formParam("legalOrPlanningRestrictionsDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))












  val getTenancyLeaseAgreementExpire: HttpRequestBuilder =
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

  val leaseOrAgreementSectionFor6010: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlord("Dru", "11 bannana valley", "Minions", "BN12 4AX"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Details of teh landlord relationship"),
    getLeaseOAgreementDetails,
    postLeaseOrAgreementDetails("yes"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1234"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60"),
    getIncludedInYourRent,
    postIncludedInYourRent("vat"),
    getDoesTheRentPayable,
    postDoesRentPayable("proprietor", "otherProperty"),
    getUltimatelyResponsible,
    postUltimatelyResponsible("landlord", "tenant", "both"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    postRentIncludeTradeServiceDetails("1234", "services"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentIncludeFixturesAndFittingsDetails,
    postRentIncludeFixturesAndFittingsDetails("1234"),
    getRentOpenMarketValue,
    postRentOpenMarketValue("yes"),
    getRentIncreaseAnnuallyWithRpi,
    postRentIncreaseAnnuallyWithRpi("yes"),
    getRentPayableVaryAccordingToGrossOrNetDetails,
    postRentPayableVaryAccordingToGrossOrNetDetails("details"),
    getRentPayableVaryOnQuantityOfBeers,
    postRentPayableVaryOnQuantityOfBeers("yes"),
    getRentPayableVaryOnQuantityOfBeersDetails,
    postRentPayableVaryOnQuantityOfBeersDetails("details"),
    getHowCurrentRentIsFixed,
    postHowCurrentRentIsFixed("newLeaseAgreement"),
    getMethodToFixCurrentRent,
    postMethodToFixCurrentRent("agreement"),
    getIntervalsOfRentReview,
    postIntervalsOfRentReview("details"),
    getCanRentBeReducedOnReview,
    postCanRentBeReducedOnReview("yes"),
    getFormerLeaseSurrendered,
    postFormerLeaseSurrendered("yes"),
    getTenantsAdditionsDisregarded,
    postTenantsAdditionsDisregarded("yes"),
    getTenantsAdditionsDisregardedDetails,
    postTenantsAdditionsDisregardedDetails("disregarded details"),
    getPayACapitalSum,
    PostPayACapitalSum("yes"),
    getReceivePaymentWhenLeaseGranted,
    postReceivePaymentWhenLeaseGranted("yes"),
    getLegalOrPlanningRestrictions,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("legal or planning restrictions details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes")
  )
}

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

  val getTypeOfTenure: HttpRequestBuilder =
    http("[GET] get type of tenure page")
      .get(s"$baseUrl/$route/type-of-tenure")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTypeOfTenure(tenureType: String, tenureDetails: String): HttpRequestBuilder =
    http("[POST] post type of tenure page")
      .post(s"$baseUrl/$route/type-of-tenure")
      .formParam("typeOfTenure[]", tenureType)
      .formParam("typeOfTenureDetails", tenureDetails)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAboutYourLandlordFor6015(name: String): HttpRequestBuilder =
    http("[POST] post about your landlord page")
      .post(s"$baseUrl/$route/about-your-landlord")
      .formParamMap(Map(
        "landlordFullName" -> name,
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

  val getProvideDetailsOfYourLease: HttpRequestBuilder =
    http("[GET] get provide details of your lease")
      .get(s"$baseUrl/$route/provide-details-of-your-lease")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postProvideDetailsOfYourLease: HttpRequestBuilder =
    http("[POST] post provide details of your lease")
      .post(s"$baseUrl/$route/provide-details-of-your-lease")
      .formParam("provideDetailsOfYourLease", "details")
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

  val getThroughputAffectsRent: HttpRequestBuilder =
    http("[GET] get throughput affects rent page")
      .get(s"$baseUrl/$route/throughput-affects-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postThroughputAffectsRent(option: String): HttpRequestBuilder =
    http("[POST] get throughput affects rent page")
      .post(s"$baseUrl/$route/throughput-affects-rent")
      .formParam("throughputAffectsRent", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getThroughputAffectsRentDetails: HttpRequestBuilder =
    http("[GET] get throughput affects rent details page" )
      .get(s"$baseUrl/$route/throughput-affects-rent-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postThroughputAffectsRentDetails(details: String): HttpRequestBuilder =
    http("[POST] post throughput affects rent details page")
      .post(s"$baseUrl/$route/throughput-affects-rent-details")
      .formParam("throughputAffectsRentDetails", details)
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
        "currentRentFirstPaid.day" -> pastDay.day,
        "currentRentFirstPaid.month" -> pastMonth.getMonthValue.toString,
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
        "leaseBegin.month" -> pastMonth.getMonthValue.toString,
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

  val getIsVatPayableForWholeProperty: HttpRequestBuilder =
    http("[GET] get is vat payable for whole property")
      .get(s"$baseUrl/$route/is-vat-payable-for-whole-property")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIsVatPayableForWholeProperty(option: String): HttpRequestBuilder =
    http("[GET] get is vat payable for whole property")
      .post(s"$baseUrl/$route/is-vat-payable-for-whole-property")
      .formParam("isVatPayableForWholeProperty", option)
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

  val getUltimatelyResponsibleInsideRepairs: HttpRequestBuilder =
    http("[GET] get ultimately responsible inside repairs page")
      .get(s"$baseUrl/$route/ultimately-responsible-inside-repairs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postUltimatelyResponsibleInsideRepairs(Option: String): HttpRequestBuilder =
    http("[POST] post ultimately responsible inside repairs page")
      .post(s"$baseUrl/$route/ultimately-responsible-inside-repairs")
      .formParam("insideRepairs", Option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getUltimatelyResponsibleOutsideRepairs: HttpRequestBuilder =
    http("[GET] get ultimately responsible outside repairs page")
      .get(s"$baseUrl/$route/ultimately-responsible-outside-repairs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postUltimatelyResponsibleOutsideRepairs(Option: String): HttpRequestBuilder =
    http("[POST] post ultimately responsible outside repairs page")
      .post(s"$baseUrl/$route/ultimately-responsible-outside-repairs")
      .formParam("outsideRepairs", Option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getUltimatelyResponsibleBuildingInsurance: HttpRequestBuilder =
    http("[GET] get ultimately responsible inside repairs page")
      .get(s"$baseUrl/$route/ultimately-responsible-building-insurance")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postUltimatelyResponsibleBuildingInsurance(Option: String): HttpRequestBuilder =
    http("[POST] post ultimately responsible outside repairs page")
      .post(s"$baseUrl/$route/ultimately-responsible-building-insurance")
      .formParam("buildingInsurance", Option)
      .formParam("sharedResponsibilitiesBI", "building insurance details")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentIncludeTradeServices: HttpRequestBuilder =
    http("[GET] get rent include trade services page")
      .get(s"$baseUrl/$route/rent-include-trade-services")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentIncludeTradeServices(option: String): HttpRequestBuilder =
    http("[POST] post rent include trade services page")
      .post(s"$baseUrl/$route/rent-include-trade-services")
      .formParam("rentIncludeTradeServices", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTradeServicesDescription: HttpRequestBuilder =
    http("[GET] get trade services description page")
      .get(s"$baseUrl/$route/trade-services-description")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))
  def postTradeServicesDescription(answer: String): HttpRequestBuilder =
    http("[POST] post trade services description page")
      .post(s"$baseUrl/$route/trade-services-description")
      .formParam("description", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTradeServicesList: HttpRequestBuilder =
    http("[GET] get trade services list page")
      .get(s"$baseUrl/$route/trade-services-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTradeServicesList(option: String): HttpRequestBuilder =
    http("[POST] post trade services list page")
      .post(s"$baseUrl/$route/trade-services-list")
      .formParam("tradeServicesList", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTradeServiceRemove: HttpRequestBuilder =
    http("[GET] get trade service remove page")
      .get(s"$baseUrl/$route/trade-services-remove")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postTradeServiceRemove(option: String): HttpRequestBuilder =
    http("[POST] post trade service remove page")
      .post(s"$baseUrl/$route/trade-services-remove")
      .formParam("genericRemoveConfirmation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))




  val getPaymentForTradeServices: HttpRequestBuilder =
    http("[GET] get payment for trade services page")
      .get(s"$baseUrl/$route/payment-for-trade-services")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPaymentForTradeServices(option: String): HttpRequestBuilder =
    http("[POST] post payment for trade services page")
      .post(s"$baseUrl/$route/payment-for-trade-services")
      .formParam("paymentForTradeServices", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getServicesPaidSeperately: HttpRequestBuilder =
    http("[GET] get service paid separately page")
      .get(s"$baseUrl/$route/service-paid-separately")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postServicesPaidSeperately(description: String): HttpRequestBuilder =
    http("[POST] post services paid separately page")
      .post(s"$baseUrl/$route/service-paid-separately")
      .formParam("description", description)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getServicesPaidSeparatelyCharge: HttpRequestBuilder =
    http("[GET] get services paid separately page")
      .get(s"$baseUrl/$route/service-paid-separately-charge")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postServicesPaidSeparatelyCharge(annualCharge: String): HttpRequestBuilder =
    http("[POST] post services paid separately page")
      .post(s"$baseUrl/$route/service-paid-separately-charge")
      .formParam("annualCharge", annualCharge)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getServicesPaidSeperatelyList: HttpRequestBuilder =
    http("[GET] get service paid separately list page")
      .get(s"$baseUrl/$route/service-paid-separately-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postServicesPaidSeperatelyList(option: String): HttpRequestBuilder =
    http("[POST] post service paid separately list page")
      .post(s"$baseUrl/$route/service-paid-separately-list")
      .formParam("servicePaidSeparatelyList", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getServicePaidSeparatelyRemove: HttpRequestBuilder =
    http("[GET] get service paid separately remove page")
      .get(s"$baseUrl/$route/service-paid-separately-list")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postServicePaidSeparatelyRemove(option: String) : HttpRequestBuilder =
    http("[POST] post service paid separately remove page")
      .post(s"$baseUrl/$route/service-paid-separately-list")
      .formParam("genericRemoveConfirmation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))


  val getDoesRentIncludeParking : HttpRequestBuilder =
    http("[GET] get does rent include parking page")
      .get(s"$baseUrl/$route/does-rent-include-parking")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postDoesRentIncludeParking(option: String): HttpRequestBuilder =
    http("[POST] post does rent include parking page")
      .post(s"$baseUrl/$route/does-rent-include-parking")
      .formParam("doesRentIncludeParking", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIncludedInRentParkingSpaces: HttpRequestBuilder =
    http("[GET] get included in rent parking spaces page")
      .get(s"$baseUrl/$route/included-in-rent-parking-spaces")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIncludedInRentParkingSpaces(openSpaces: String, coveredSpaces:String, garages:String ): HttpRequestBuilder =
    http("[POST] get included in rent parking spaces page")
      .post(s"$baseUrl/$route/included-in-rent-parking-spaces")
      .formParamMap(Map(
        "openSpaces" -> openSpaces,
        "coveredSpaces" -> coveredSpaces,
        "garages" -> garages,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getIsParkingRentPaidSeparately: HttpRequestBuilder =
    http("[GET] get is parking rent paid separately page")
      .get(s"$baseUrl/$route/is-parking-rent-paid-separately")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIsParkingRentPaidSeparately(option: String): HttpRequestBuilder =
    http("[POST] post is parking rent paid separately page")
      .post(s"$baseUrl/$route/is-parking-rent-paid-separately")
      .formParam("isParkingRentPaidSeparately", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRentedSeparatelyParkingSpaces: HttpRequestBuilder =
    http("[GET] get rented separately parking spaces page")
      .get(s"$baseUrl/$route/rented-separately-parking-spaces")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentedSeparatelyParkingSpaces(openSpaces: String, coveredSpaces:String, garages:String): HttpRequestBuilder =
    http("[POST] post rented separately parking spaces page")
      .post(s"$baseUrl/$route/rented-separately-parking-spaces")
      .formParamMap(Map(
        "openSpaces" -> openSpaces,
        "coveredSpaces" -> coveredSpaces,
        "garages" -> garages,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCarParkingAnnualRent: HttpRequestBuilder =
    http("[GET] get car parking annual rent page")
      .get(s"$baseUrl/$route/car-parking-annual-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCarParkingAnnualRent(annualRent: String): HttpRequestBuilder =
    http("[POST] post car parking annual rent page ")
      .post(s"$baseUrl/$route/car-parking-annual-rent")
      .formParamMap(Map(
        "annualRent" -> annualRent,
        "fixedRentFrom.day" -> today.day,
        "fixedRentFrom.month" -> today.month,
        "ixedRentFrom.year" -> today.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
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

  val getRentedEquipmentDetails: HttpRequestBuilder =
    http("[GET] get rented equipment details page")
      .get(s"$baseUrl/$route/rented-equipment-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentedEquipmentDetails(details: String): HttpRequestBuilder =
    http("[POST] post rented equipment details page")
      .post(s"$baseUrl/$route/rented-equipment-details")
      .formParam("rentedEquipmentDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getIncludedInRent: HttpRequestBuilder =
    http("[GET] get included in rent page")
      .get(s"$baseUrl/$route/included-in-rent")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postIncludedInRent(option1: String, option2: String, details: String): HttpRequestBuilder =
    http("[POST] post included in rent page")
      .post(s"$baseUrl/$route/included-in-rent")
      .formParamMap(Map(
        "rentPayable[]" -> option1,
         " rentPayable[]"-> option2,
       "rentPayableDetails" -> details,
        "csrfToken" -> f"$${csrfToken}"
      ))
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

  val getWhatIsYourRentBasedOn: HttpRequestBuilder =
    http("[GET] get what is your rent based on page")
      .get(s"$baseUrl/$route/what-is-your-rent-based-on")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWhatIsYourRentBasedOn(option: String): HttpRequestBuilder =
    http("[POST] post what is your rent based on page")
      .post(s"$baseUrl/$route/rent-open-market-value")
      .formParam("currentRentBasedOn", option)
      .formParam("whatIsYourRentBasedOn", "Additional details")
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

  val getRentPayableVaryAccordingToGrossOrNet: HttpRequestBuilder =
    http("[GET] get rent payable vary according to gross or net page")
      .get(s"$baseUrl/$route/rent-payable-vary-according-to-gross-or-net")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postRentPayableVaryAccordingToGrossOrNet(option: String): HttpRequestBuilder =
    http("[GET] get rent payable vary according to gross or net page")
      .post(s"$baseUrl/$route/rent-payable-vary-according-to-gross-or-net")
      .formParam("rentPayableVaryAccordingToGrossOrNet", option)
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
        "nextReview.year" -> today.year,
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

  val getPropertyUpdates: HttpRequestBuilder =
    http("[GET] get property updates page")
      .get(s"$baseUrl/$route/property-updates")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPropertyUpdates(option: String): HttpRequestBuilder =
    http("[POST] post property updates page")
      .post(s"$baseUrl/$route/property-updates")
      .formParam("propertyUpdates", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getWorkCarriedOutDetails: HttpRequestBuilder =
    http("[GET] get work carried out details page")
      .get(s"$baseUrl/$route/work-carried-out-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWorkCarriedOutDetails(answer: String): HttpRequestBuilder =
    http("[POST] post work carried out details page")
      .post(s"$baseUrl/$route/work-carried-out-details")
      .formParam("workCarriedOutDetails", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getWorkCarriedOutCondition: HttpRequestBuilder =
    http("[GET] get work carried out condition page")
      .get(s"$baseUrl/$route/work-carried-out-condition")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postWorkCarriedOutCondition(option: String): HttpRequestBuilder =
    http("[POST] post work carried out condition page")
      .post(s"$baseUrl/$route/work-carried-out-condition")
      .formParam("workCarriedOutCondition", option)
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

  val getLeaseSurrenderedEarly: HttpRequestBuilder =
    http("[GET] get lease surrendered early page")
      .get(s"$baseUrl/$route/lease-surrendered-early")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLeaseSurrenderedEarly(option: String): HttpRequestBuilder =
    http("[POST] post lease surrendered early page")
      .post(s"$baseUrl/$route/lease-surrendered-early")
      .formParam("leaseSurrenderedEarly", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getBenefitsGivenDetails: HttpRequestBuilder =
    http("[GET] get benefits given details page")
      .get(s"$baseUrl/$route/benefits-given-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postBenefitsGivenDetails(details: String): HttpRequestBuilder =
    http("[POST] post benefits given details page")
      .post(s"$baseUrl/$route/benefits-given-details")
      .formParam("benefitsGivenDetails", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPayACapitalSum : HttpRequestBuilder =
    http("[GET] get pay a capital sum page")
      .get(s"$baseUrl/$route/pay-a-capital-sum")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPayACapitalSum(option: String) : HttpRequestBuilder =
    http("[POST] post pay a capital sum page")
      .post(s"$baseUrl/$route/pay-a-capital-sum")
      .formParam("payACapitalSum", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPayACapitalSumDetails: HttpRequestBuilder =
    http("[GET] get pay a capital sum details page")
      .get(s"$baseUrl/$route/pay-a-capital-sum-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postPayACapitalSumDetails(answer: String): HttpRequestBuilder =
    http("[POST] post capital pay a sum details page")
      .post(s"$baseUrl/$route/pay-a-capital-sum")
      .formParamMap(Map(
        "capitalSumPaidDetails" -> answer,
        "capitalSumPaidDetailsDateInput.day" -> today.day,
        "capitalSumPaidDetailsDateInput.month" -> today.month,
        "capitalSumPaidDetailsDateInput.year" -> today.year,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))


  val getCapitalSumDescription: HttpRequestBuilder =
    http("[GET] get capital sum description page")
      .get(s"$baseUrl/$route/capital-sum-description")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCapitalSumDescription(description:String): HttpRequestBuilder =
    http("[POST] post capital sum description page" )
      .post(s"$baseUrl/$route/capital-sum-description")
      .formParam("capitalSumDescription", description)
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
    postCurrentAnnualRent("10000"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60"),
    getIncludedInYourRent,
    postIncludedInYourRent("vat"),
    getDoesTheRentPayable,
    postDoesRentPayable("proprietor", "otherProperty"),
    getUltimatelyResponsibleInsideRepairs,
    postUltimatelyResponsibleInsideRepairs("landlord"),
    getUltimatelyResponsibleOutsideRepairs,
    postUltimatelyResponsibleOutsideRepairs("tenant"),
    getUltimatelyResponsibleBuildingInsurance,
    postUltimatelyResponsibleBuildingInsurance("both"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    postRentIncludeTradeServiceDetails("1234", "services"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentIncludeFixturesAndFittingsDetails,
    postRentIncludeFixturesAndFittingsDetails("0"),
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
    postPayACapitalSum("yes"),
    getReceivePaymentWhenLeaseGranted,
    postReceivePaymentWhenLeaseGranted("yes"),
    getLegalOrPlanningRestrictions,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("legal or planning restrictions details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes")
  )

  val leaseOrAgreementSectionFor6015: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlordFor6015("Dru"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Details to landlord"),
    getLeaseOAgreementDetails,
    postLeaseOrAgreementDetails("yes"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1000"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60"),
    getIncludedInYourRent,
    postIncludedInYourRent("vat"),
    getDoesTheRentPayable,
    postDoesRentPayable("proprietor", "otherProperty"),
    getUltimatelyResponsibleOutsideRepairs,
    postUltimatelyResponsibleOutsideRepairs("landlord"),
    getUltimatelyResponsibleInsideRepairs,
    postUltimatelyResponsibleInsideRepairs("landlord"),
    getUltimatelyResponsibleBuildingInsurance,
    postUltimatelyResponsibleBuildingInsurance("landlord"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    getRentIncludeTradeServicesDetails,
    postRentIncludeTradeServiceDetails("1000", "trade service details"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentIncludeFixturesAndFittingsDetails,
    postRentIncludeFixturesAndFittingsDetails("0"),
    getRentOpenMarketValue,
    postRentOpenMarketValue("yes"),
    getRentIncreaseAnnuallyWithRpi,
    postRentIncreaseAnnuallyWithRpi("yes"),
    getRentPayableVaryAccordingToGrossOrNet,
    postRentPayableVaryAccordingToGrossOrNet("yes"),
    getRentPayableVaryAccordingToGrossOrNetDetails,
    postRentPayableVaryAccordingToGrossOrNetDetails("Details"),
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
    postTenantsAdditionsDisregardedDetails("Disregarded details"),
    getPayACapitalSum,
    postPayACapitalSum("yes"),
    getReceivePaymentWhenLeaseGranted,
    postReceivePaymentWhenLeaseGranted("yes"),
    getLegalOrPlanningRestrictions,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("Legal or Planning restrictions details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes"))

  val leaseOrAgreementSectionFor6016: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlordFor6015("Dru"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Details to landlord"),
    getLeaseOAgreementDetails,
    postLeaseOrAgreementDetails("yes"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1000"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60"),
    getIncludedInYourRent,
    postIncludedInYourRent("vat"),
    getDoesTheRentPayable,
    postDoesRentPayable("proprietor", "otherProperty"),
    getUltimatelyResponsibleOutsideRepairs,
    postUltimatelyResponsibleOutsideRepairs("landlord"),
    getUltimatelyResponsibleInsideRepairs,
    postUltimatelyResponsibleInsideRepairs("landlord"),
    getUltimatelyResponsibleBuildingInsurance,
    postUltimatelyResponsibleBuildingInsurance("landlord"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    getRentIncludeTradeServicesDetails,
    postRentIncludeTradeServiceDetails("1000", "trade service details"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentIncludeFixturesAndFittingsDetails,
    postRentIncludeFixturesAndFittingsDetails("0"),
    getRentOpenMarketValue,
    postRentOpenMarketValue("yes"),
    getRentIncreaseAnnuallyWithRpi,
    postRentIncreaseAnnuallyWithRpi("yes"),
    getRentPayableVaryAccordingToGrossOrNet,
    postRentPayableVaryAccordingToGrossOrNet("yes"),
    getRentPayableVaryAccordingToGrossOrNetDetails,
    postRentPayableVaryAccordingToGrossOrNetDetails("Details"),
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
    postTenantsAdditionsDisregardedDetails("Disregarded details"),
    getPayACapitalSum,
    postPayACapitalSum("yes"),
    getReceivePaymentWhenLeaseGranted,
    postReceivePaymentWhenLeaseGranted("yes"),
    getLegalOrPlanningRestrictions,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("Legal or Planning restrictions details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes"))

  val leaseOrAgreementSectionFor6020: Seq[HttpRequestBuilder] = Seq(
    getTypeOfTenure,
    postTypeOfTenure("leasehold", "tenure details"),
    getAboutYourLandlord,
    postAboutYourLandlordFor6015("Dru"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1000"),
    getThroughputAffectsRent,
    postThroughputAffectsRent("yes"),
    getThroughputAffectsRentDetails,
    postThroughputAffectsRentDetails("throughput affects rent details"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60 months"),
    getIncludedInYourRent,
    postIncludedInYourRent("vat"),
    getIsVatPayableForWholeProperty,
    postIsVatPayableForWholeProperty("yes"),
    getUltimatelyResponsibleOutsideRepairs,
    postUltimatelyResponsibleOutsideRepairs("landlord"),
    getUltimatelyResponsibleInsideRepairs,
    postUltimatelyResponsibleInsideRepairs("landlord"),
    getUltimatelyResponsibleBuildingInsurance,
    postUltimatelyResponsibleBuildingInsurance("landlord"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    getTradeServicesDescription,
    postTradeServicesDescription("trade service details"),
    getTradeServicesList,
    postTradeServicesList("yes"),
    getServicesPaidSeperately,
    postServicesPaidSeperately("description"),
    getServicesPaidSeparatelyCharge,
    postServicesPaidSeparatelyCharge("1234"),
    getServicesPaidSeperatelyList,
    postServicesPaidSeperatelyList("no"),
    getDoesRentIncludeParking,
    postDoesRentIncludeParking("yes"),
    getIncludedInRentParkingSpaces,
    postIncludedInRentParkingSpaces("10", "10", "22"),
    getIsParkingRentPaidSeparately,
    postIsParkingRentPaidSeparately("yes"),
    getRentedSeparatelyParkingSpaces,
    postRentedSeparatelyParkingSpaces("10", "10", "22"),
    getCarParkingAnnualRent,
    postCarParkingAnnualRent("1234"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentedEquipmentDetails,
    postRentedEquipmentDetails("details"),
    getIncludedInRent,
    postIncludedInRent("fullyEquippedStation", "otherProperty", "" ),
    getRentOpenMarketValue,
    postRentOpenMarketValue("yes"),
    getHowCurrentRentIsFixed,
    postHowCurrentRentIsFixed("newLeaseAgreement"),
    getMethodToFixCurrentRent,
    postMethodToFixCurrentRent("agreement"),
    getIntervalsOfRentReview,
    postIntervalsOfRentReview("yearly"),
    getCanRentBeReducedOnReview,
    postCanRentBeReducedOnReview("yes"),
    getPropertyUpdates,
    postPropertyUpdates("yes"),
    getWorkCarriedOutDetails,
    postWorkCarriedOutDetails("details"),
    getWorkCarriedOutCondition,
    postWorkCarriedOutCondition("yes"),
    getTenantsAdditionsDisregarded,
    postTenantsAdditionsDisregarded("yes"),
    getTenantsAdditionsDisregardedDetails,
    postTenantsAdditionsDisregardedDetails("yes"),
    getLeaseSurrenderedEarly,
    postLeaseSurrenderedEarly("yes"),
    getBenefitsGivenDetails,
    postBenefitsGivenDetails("Details"),
    getPayACapitalSum,
    postPayACapitalSum("yes"),
    getCapitalSumDescription,
    postCapitalSumDescription("Details"),
    getLegalOrPlanningRestrictions,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("Details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes"))

  val leaseOrAgreementSectionFor6030: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlordFor6015("Dru"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Connected to landlord details"),
    getLeaseOAgreementDetails,
    postLeaseOrAgreementDetails("yes"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getCurrentAnnualRent,
    postCurrentAnnualRent("1234"),
    getCurrentRentFirstPaid,
    postCurrentRentFirstPaid,
    getCurrentLeaseOrAgreementBegin,
    postCurrentLeaseOrAgreementBegin("60 months"),
    getIncludedInRent,
    postIncludedInRent("vat", "nondomesticRates", "additional details"),
    getDoesTheRentPayable,
    postDoesRentPayable("proprietor", "otherProperty"),
    getUltimatelyResponsibleOutsideRepairs,
    postUltimatelyResponsibleOutsideRepairs("landlord"),
    getUltimatelyResponsibleInsideRepairs,
    postUltimatelyResponsibleInsideRepairs("tenant"),
    getUltimatelyResponsibleBuildingInsurance,
    postUltimatelyResponsibleBuildingInsurance("both"),
    getRentIncludeTradeServices,
    postRentIncludeTradeServices("yes"),
    getTradeServicesDescription,
    postTradeServicesDescription("Trade service description"),
    getTradeServicesList,
    getTradeServiceRemove,
    postTradeServiceRemove("no"),
    postTradeServicesList("no"),
    getPaymentForTradeServices,
    postPaymentForTradeServices("yes"),
    getServicesPaidSeperately,
    postServicesPaidSeperately("services paid separately"),
    getServicesPaidSeparatelyCharge,
    postServicesPaidSeparatelyCharge("1234"),
    getServicesPaidSeperatelyList,
    getServicePaidSeparatelyRemove,
    getServicePaidSeparatelyRemove,
    postServicePaidSeparatelyRemove("no"),
    postServicesPaidSeperatelyList("no"),
    getRentIncludeFixturesAndFittings,
    postRentIncludeFixturesAndFittings("yes"),
    getRentIncludeFixturesAndFittingsDetails,
    postRentIncludeFixturesAndFittingsDetails("1234"),
    getRentOpenMarketValue,
    postRentOpenMarketValue("yes"),
    getWhatIsYourRentBasedOn,
    postWhatIsYourRentBasedOn("fixed"),
    getRentPayableVaryAccordingToGrossOrNet,
    postRentPayableVaryAccordingToGrossOrNet("yes"),
    getRentPayableVaryAccordingToGrossOrNetDetails,
    postRentPayableVaryAccordingToGrossOrNetDetails("details"),
    getHowCurrentRentIsFixed,
    postHowCurrentRentIsFixed("newLeaseAgreement"),
    getMethodToFixCurrentRent,
    postMethodToFixCurrentRent("methodUsedToFixCurrentRent"),
    getIntervalsOfRentReview,
    postIntervalsOfRentReview("rent review"),
    getCanRentBeReducedOnReview,
    postCanRentBeReducedOnReview("yes"),
    getFormerLeaseSurrendered,
    postFormerLeaseSurrendered("yes"),
    getTenantsAdditionsDisregarded,
    postTenantsAdditionsDisregarded("yes"),
    getTenantsAdditionsDisregardedDetails,
    postTenantsAdditionsDisregardedDetails("details"),
    getPayACapitalSum,
    postPayACapitalSum("yes"),
    getPayACapitalSumDetails,
    postPayACapitalSumDetails("1234"),
    getReceivePaymentWhenLeaseGranted,
    postReceivePaymentWhenLeaseGranted("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictions("yes"),
    getLegalOrPlanningRestrictionsDetails,
    postLegalOrPlanningRestrictionsDetails("details"),
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes"))

  val leaseOrAgreementSectionFor6076: Seq[HttpRequestBuilder] = Seq(
    getAboutYourLandlord,
    postAboutYourLandlordFor6015("Dru"),
    getConnectionToLandlord,
    postConnectionToLandlord("yes"),
    getConnectedLandlordDetails,
    postConnectedLandlordDetails("Connected to landlord details"),
    getPropertyUseLeaseBackArrangement,
    postPropertyUseLeaseBackArrangement("yes"),
    getProvideDetailsOfYourLease,
    postProvideDetailsOfYourLease,
    getCYALeaseOrTenure,
    postCYALeaseOrTenure("yes"))

}

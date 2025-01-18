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
import utils.DateUtils._

object TradingHistoryRequests extends HttpConfiguration with servicesConfig {

  val getWhatYouWillNeed: HttpRequestBuilder =
    http("[GET] get what you will need page")
      .get(s"$baseUrl/$route/what-you-will-need")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAboutYourTradingHistory: HttpRequestBuilder =
    http("[GET] get about your trading history page")
      .get(s"$baseUrl/$route/about-your-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAboutYourTradingHistory: HttpRequestBuilder =
    http("[POST] post about your trading history page")
      .post(s"$baseUrl/$route/about-your-trading-history")
      .formParam("firstOccupy.month", pastMonth.getMonthValue.toString)
      .formParam("firstOccupy.year", today.getYear.toString)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFinancialYearEnd: HttpRequestBuilder =
    http("[GET] get financial year end page")
      .get(s"$baseUrl/$route/financial-year-end")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFinancialYearEnd: HttpRequestBuilder =
    http("[POST] post financial year end page")
      .post(s"$baseUrl/$route/financial-year-end")
      .formParam("financialYear.day", today.day)
      .formParam("financialYear.month", today.month)
      .formParam("yearEndChanged", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFinancialYearEndDatesSummary: HttpRequestBuilder =
    http("[GET] get financial year end dates summary page")
      .get(s"$baseUrl/$route/financial-year-end-dates-summary")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getFinancialYears: HttpRequestBuilder =
    http("[GET] get financial years page")
      .get(s"$baseUrl/$route/financial-years")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFinancialYears: HttpRequestBuilder =
    http("[POST] post financial years page")
      .post(s"$baseUrl/$route/financial-years")
      .formParam("isFinancialYearsCorrect", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getElectricityGenerated: HttpRequestBuilder =
    http("[GET] get electricity generated page")
      .get(s"$baseUrl/$route/electricity-generated")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getGrossReceiptsExcludingVat: HttpRequestBuilder =
    http("[GET] get gross receipts excluding VAT receipts page")
      .get(s"$baseUrl/$route/gross-receipts-excluding-vat")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getStaticCaravans: HttpRequestBuilder =
    http("[GET] get static caravans page")
      .get(s"$baseUrl/$route/static-caravans")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postStaticCaravans: HttpRequestBuilder =
    http("[POST] post static caravans page")
      .post(s"$baseUrl/$route/static-caravans")
      .formParam("staticCaravans", "yes")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAreCaravansOpenAllYear: HttpRequestBuilder =
    http("[GET] are caravans open all year page")
      .get(s"$baseUrl/$route/are-caravans-open-all-year")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAreCaravansOpenAllYear: HttpRequestBuilder =
    http("[POST] are caravans open all year page")
      .post(s"$baseUrl/$route/are-caravans-open-all-year")
      .formParam("areCaravansOpenAllYear", "yes")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getGrossReceiptsFleetCaravan: HttpRequestBuilder =
    http("[GET] gross receipts fleet caravan page")
      .get(s"$baseUrl/$route/gross-receipts-fleet-caravans")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postGrossReceiptsFleetCaravan: HttpRequestBuilder =
    http("[POST] gross receipts fleet caravan page")
      .post(s"$baseUrl/$route/gross-receipts-fleet-caravans")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> "52",
          "turnover[0].grossReceipts" -> "123",
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getSingleCaravansOwnedByOperator: HttpRequestBuilder =
    http("[GET] single caravans owned by operator page")
      .get(s"$baseUrl/$route/single-caravans-owned-by-operator")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postSingleCaravansOwnedByOperator: HttpRequestBuilder =
    http("[POST] single caravans owned by operator page")
      .post(s"$baseUrl/$route/single-caravans-owned-by-operator")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> "52",
          "turnover[0].grossReceipts" -> "123",
          "turnover[0].vans"          -> "123",
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getSingleCaravansSublet: HttpRequestBuilder =
    http("[GET] single caravans sublet page")
      .get(s"$baseUrl/$route/single-caravans-sublet")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postSingleCaravansSublet: HttpRequestBuilder =
    http("[POST] single caravans sublet page")
      .post(s"$baseUrl/$route/single-caravans-sublet")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> "52",
          "turnover[0].grossReceipts" -> "123",
          "turnover[0].vans"          -> "123",
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getSingleCaravanAgeCategories: HttpRequestBuilder =
    http("[GET] single caravans age categories page")
      .get(s"$baseUrl/$route/single-caravans-age-categories")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postSingleCaravanAgeCategories: HttpRequestBuilder =
    http("[POST] single caravans age categories page")
      .post(s"$baseUrl/$route/single-caravans-age-categories")
      .formParamMap(
        Map(
          "fleetHire.years0_5"        -> 11,
          "fleetHire.years6_10"       -> 11,
          "fleetHire.years11_15"      -> 222,
          "fleetHire.years15plus"     -> 22,
          "privateSublet.years0_5"    -> 11,
          "privateSublet.years6_10"   -> 11,
          "privateSublet.years11_15"  -> 11,
          "privateSublet.years15plus" -> 22,
          "idx"                       -> 0,
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getOtherIncome: HttpRequestBuilder =
    http("[GET] get other income page")
      .get(s"$baseUrl/$route/other-income")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTwinUnitCaravansOwnedByOperator: HttpRequestBuilder =
    http("[GET] twin unit caravans owned by operator page")
      .get(s"$baseUrl/$route/twin-unit-caravans-owned-by-operator")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTwinUnitCaravansOwnedByOperator: HttpRequestBuilder =
    http("[POST] twin unit caravans owned by operator page")
      .post(s"$baseUrl/$route/twin-unit-caravans-owned-by-operator")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> "52",
          "turnover[0].grossReceipts" -> "123",
          "turnover[0].vans"          -> "123",
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getTwinUnitCaravansSubLet: HttpRequestBuilder =
    http("[GET] get twin unit caravans sublet page")
      .get(s"$baseUrl/$route/twin-unit-caravans-sublet")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTwinUnitCaravansSubLet: HttpRequestBuilder =
    http("[POST] get twin unit caravans sublet page")
      .post(s"$baseUrl/$route/twin-unit-caravans-sublet")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> "52",
          "turnover[0].grossReceipts" -> "123",
          "turnover[0].vans"          -> "123",
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getTwinUnitCaravansAgeCategories: HttpRequestBuilder =
    http("[GET] get twin unit caravans age categories page")
      .get(s"$baseUrl/$route/twin-unit-caravans-age-categories")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTwinUnitCaravansAgeCategories: HttpRequestBuilder =
    http("[POST] post twin unit caravans age categories page")
      .post(s"$baseUrl/$route/twin-unit-caravans-age-categories")
      .formParamMap(
        Map(
          "fleetHire.years0_5"        -> 11,
          "fleetHire.years6_10"       -> 11,
          "fleetHire.years11_15"      -> 222,
          "fleetHire.years15plus"     -> 22,
          "privateSublet.years0_5"    -> 11,
          "privateSublet.years6_10"   -> 11,
          "privateSublet.years11_15"  -> 11,
          "privateSublet.years15plus" -> 22,
          "idx"                       -> 0,
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCaravansSiteCapacity: HttpRequestBuilder =
    http("[GET] caravans site capacity page")
      .get(s"$baseUrl/$route/caravans-site-capacity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCaravansSiteCapacity: HttpRequestBuilder =
    http("[POST] caravans site capacity page")
      .get(s"$baseUrl/$route/caravans-site-capacity")
      .formParamMap(
        Map(
          "ownedByOperatorForFleetHire"     -> 11,
          "privatelyOwnedForOwnerAndFamily" -> 22,
          "subletByOperator"                -> 33,
          "subletByPrivateOwners"           -> 44,
          "charitablePurposes"              -> 66,
          "seasonalStaff"                   -> 66,
          "csrfToken"                       -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCaravansPerService: HttpRequestBuilder =
    http("[GET] caravans per service page")
      .get(s"$baseUrl/$route/caravans-per-service")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCaravansPerService: HttpRequestBuilder =
    http("[POST] caravans per service page")
      .post(s"$baseUrl/$route/caravans-per-service")
      .formParamMap(
        Map(
          "fleetWaterElectricityDrainage"   -> 12,
          "fleetElectricityOnly"            -> 22,
          "privateWaterElectricityDrainage" -> 22,
          "privateElectricityOnly"          -> 22,
          "csrfToken"                       -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCaravansAnnualPitchFee: HttpRequestBuilder =
    http("[GET] caravans annual pitch fee page")
      .get(s"$baseUrl/$route/caravans-annual-pitch-fee")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postCaravansAnnualPitchFee: HttpRequestBuilder =
    http("[POST] caravans annual pitch fee page")
      .post(s"$baseUrl/$route/caravans-annual-pitch-fee")
      .formParamMap(
        Map(
          "totalPitchFee"                -> 12000,
          "servicesIncludedInPitchFee[]" -> "rates",
          "rates"                        -> 11,
          "csrfToken"                    -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCheckYourAnswersAboutTheTradingHistory: HttpRequestBuilder =
    http("[GET] check your answers about the trading history page")
      .get(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getOtherHolidayAccommodation: HttpRequestBuilder =
    http("[GET] other holiday accommodation page")
      .get(s"$baseUrl/$route/other-holiday-accommodation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postOtherHolidayAccommodation: HttpRequestBuilder =
    http("[POST] other holiday accommodation page")
      .post(s"$baseUrl/$route/other-holiday-accommodation")
      .formParam("otherHolidayAccommodation", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getOtherHolidayAccommodationOpenAllYear: HttpRequestBuilder =
    http("[GET] other holiday accommodation open all year page")
      .get(s"$baseUrl/$route/other-holiday-accommodation-open-all-year")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postOtherHolidayAccommodationOpenAllYear: HttpRequestBuilder =
    http("[POST] other holiday accommodation open all year page")
      .post(s"$baseUrl/$route/other-holiday-accommodation-open-all-year")
      .formParam("otherHolidayAccommodationOpenAllYear", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getGrossReceiptsLettingUnits: HttpRequestBuilder =
    http("[GET] gross receipts letting units page")
      .get(s"$baseUrl/$route/gross-receipts-letting-units")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postGrossReceiptsLettingUnits: HttpRequestBuilder =
    http("[POST] gross receipts letting units page")
      .post(s"$baseUrl/$route/gross-receipts-letting-units")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> 52,
          "turnover[0].grossReceipts" -> 123,
          "turnover[0].numberOfUnits" -> 12,
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getGrossReceiptsSubLetUnits: HttpRequestBuilder =
    http("[GET] gross receipts sub let units page")
      .get(s"$baseUrl/$route/gross-receipts-letting-units")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postGrossReceiptsSubLetUnits: HttpRequestBuilder =
    http("[POST] gross receipts sub let units page")
      .post(s"$baseUrl/$route/gross-receipts-letting-units")
      .formParamMap(
        Map(
          "turnover[0].weeks"         -> 52,
          "turnover[0].grossReceipts" -> 123,
          "turnover[0].numberOfUnits" -> 12,
          "csrfToken"                 -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getTotalSiteCapacity: HttpRequestBuilder =
    http("[GET] total site capacity page")
      .get(s"$baseUrl/$route/total-site-capacity")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTotalSiteCapacity: HttpRequestBuilder =
    http("[POST] total site capacity page")
      .post(s"$baseUrl/$route/total-site-capacity")
      .formParamMap(
        Map(
          "availableForLetting"     -> 1,
          "occupiedBySeasonalStuff" -> 1,
          "privatelyOwned"          -> 1,
          "idx"                     -> 0,
          "csrfToken"               -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCheckYourAnswersOtherHolidayAccommodation: HttpRequestBuilder =
    http("[GET] check your answers other holiday accommodation page")
      .get(s"$baseUrl/$route/check-your-answers-other-holiday-accommodation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTentingPitchesOnSite: HttpRequestBuilder =
    http("[GET] tenting pitches on site page")
      .get(s"$baseUrl/$route/tenting-pitches-on-site")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTentingPitchesOnSite: HttpRequestBuilder =
    http("[POST] tenting pitches on site page")
      .post(s"$baseUrl/$route/tenting-pitches-on-site")
      .formParam("tentingPitchesOnSite", "true")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTentingPitchesAllYear: HttpRequestBuilder =
    http("[GET] tenting pitches all year page")
      .get(s"$baseUrl/$route/tenting-pitches-all-year")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTentingPitchesAllYear: HttpRequestBuilder =
    http("[POST] tenting pitches all year page")
      .post(s"$baseUrl/$route/tenting-pitches-all-year")
      .formParam("tentingPitchesAllYear", "true")
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPitchesForCaravans: HttpRequestBuilder =
    http("[GET] pitches for caravans page")
      .get(s"$baseUrl/$route/pitches-for-caravans")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postPitchesForCaravans: HttpRequestBuilder =
    http("[POST] pitches for caravans page")
      .post(s"$baseUrl/$route/pitches-for-caravans")
      .formParam("tentingPitches[0].weeks", 12)
      .formParam("tentingPitches[0].grossReceipts", 20)
      .formParam("tentingPitches[0].numberOfPitches", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getPitchesForGlamping: HttpRequestBuilder =
    http("[GET] pitches for glamping page")
      .get(s"$baseUrl/$route/pitches-for-glamping")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postPitchesForGlamping: HttpRequestBuilder =
    http("[POST] pitches for glamping page")
      .post(s"$baseUrl/$route/pitches-for-glamping")
      .formParam("tentingPitches[0].weeks", 12)
      .formParam("tentingPitches[0].grossReceipts", 20)
      .formParam("tentingPitches[0].numberOfPitches", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getRallyAreas: HttpRequestBuilder =
    http("[GET] rally areas page")
      .get(s"$baseUrl/$route/rally-areas")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postRallyAreas: HttpRequestBuilder =
    http("[POST] rally areas page")
      .post(s"$baseUrl/$route/rally-areas")
      .formParam("rallyAreas[0].weeks", 12)
      .formParam("rallyAreas[0].grossReceipts", 20)
      .formParam("rallyAreas[0].areasInHectares", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTentingPitchesTotal: HttpRequestBuilder =
    http("[GET] tenting pitches total page")
      .get(s"$baseUrl/$route/tenting-pitches-total")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTentingPitchesTotal: HttpRequestBuilder =
    http("[POST] tenting pitches total page")
      .post(s"$baseUrl/$route/tenting-pitches-total")
      .formParam("tentingPitchesTotal", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getTentingPitchesCertificated: HttpRequestBuilder =
    http("[GET] tenting pitches total page")
      .get(s"$baseUrl/$route/tenting-pitches-total")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postTentingPitchesCertificated: HttpRequestBuilder =
    http("[POST] tenting pitches total page")
      .post(s"$baseUrl/$route/tenting-pitches-total")
      .formParam("tentingPitchesCertificated", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getCheckYourAnswersTentingPitches: HttpRequestBuilder =
    http("[GET] check your answers tenting pitches page")
      .get(s"$baseUrl/$route/check-your-answers-tenting-pitches")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAdditionActivitiesOnSite: HttpRequestBuilder =
    http("[GET] additional activities on site page")
      .get(s"$baseUrl/$route/additional-activities-on-site")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionActivitiesOnSite: HttpRequestBuilder =
    http("[POST] additional activities on site page")
      .post(s"$baseUrl/$route/additional-activities-on-site")
      .formParam("additionalActivitiesOnSite", "true")
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAdditionalShops: HttpRequestBuilder =
    http("[GET] additional shops page")
      .get(s"$baseUrl/$route/additional-shops")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionalShops: HttpRequestBuilder =
    http("[POST] additional shops page")
      .post(s"$baseUrl/$route/additional-shops")
      .formParam("additionalShops[0].weeks", 12)
      .formParam("additionalShops[0].grossReceipts", 20)
      .formParam("additionalShops[0].costOfPurchase", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAdditionalCatering: HttpRequestBuilder =
    http("[GET] additional catering page")
      .get(s"$baseUrl/$route/additional-catering")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionalCatering: HttpRequestBuilder =
    http("[GET] additional catering page")
      .get(s"$baseUrl/$route/additional-catering")
      .formParam("additionalShops[0].weeks", 12)
      .formParam("additionalShops[0].grossReceipts", 20)
      .formParam("additionalShops[0].costOfPurchase", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAdditionalBarsClubs: HttpRequestBuilder =
    http("[GET] additional bars clubs page")
      .get(s"$baseUrl/$route/dditional-bars-clubs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionalBarsClubs: HttpRequestBuilder =
    http("[POST] additional bars clubs page")
      .post(s"$baseUrl/$route/additional-bars-clubs")
      .formParamMap(
        Map(
          "additionalBarsClubs[0].weeks"               -> 52,
          "additionalBarsClubs[0].grossBar"            -> 11,
          "additionalBarsClubs[0].costBar"             -> 11,
          "additionalBarsClubs[0].grossClubMembership" -> 11,
          "additionalBarsClubs[0].grossFromSeparate"   -> 11,
          "additionalBarsClubs[0].costOfEntertainment" -> 11,
          "csrfToken"                                  -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getAdditionalAmusements: HttpRequestBuilder =
    http("[GET] additional amusements page")
      .get(s"$baseUrl/$route/additional-amusements")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionalAmusements: HttpRequestBuilder =
    http("[POST] additional amusements page")
      .post(s"$baseUrl/$route/additional-amusements")
      .formParam("additionalAmusements[0].weeks", 20)
      .formParam("additionalAmusements[0].receipts", 20)
      .formParam("idx", 0)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAdditionalMisc: HttpRequestBuilder =
    http("[GET] additional amusements page")
      .get(s"$baseUrl/$route/additional-amusements")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postAdditionalMisc: HttpRequestBuilder =
    http("[POST] additional amusements page")
      .post(s"$baseUrl/$route/additional-amusements")
      .formParamMap(
        Map(
          "additionalMisc.[0].tradingPeriod"           -> 52,
          "additionalMisc.[0].leisureReceipt"          -> 122,
          "details.leisureReceiptsDetails"             -> "leisure details",
          "additionalMisc.[0].winterStorageReceipts"   -> 11,
          "additionalMisc.[0].numberOfVans"            -> 1,
          "additionalMisc.[0].otherActivitiesReceipts" -> 2345,
          "details.otherActivitiesReceiptsDetails"     -> "other activities details",
          "additionalMisc.[0].otherServicesReceipts"   -> 1234,
          "additionalMisc.[0].bottledGasReceipts"      -> 123,
          "idx"                                        -> 0,
          "csrfToken"                                  -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  val getCheckYourAnswersAdditionalActivities: HttpRequestBuilder =
    http("[GET] check your answers additional activities page")
      .get(s"$baseUrl/$route/check-your-answers-additional-activities")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCostOfSalesIntermittent: HttpRequestBuilder =
    http("[GET] get cost of sales intermittent page")
      .get(s"$baseUrl/$route/cost-of-sales-intermittent-6076")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getStaffCosts: HttpRequestBuilder =
    http("[GET] get staff costs page")
      .get(s"$baseUrl/$route/staff-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getPremisesCosts: HttpRequestBuilder =
    http("[GET] get premises costs page")
      .get(s"$baseUrl/$route/premises-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getOperationalExpenses: HttpRequestBuilder =
    http("[GET] get operational expenses")
      .get(s"$baseUrl/$route/operational-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getHeadOfficeExpenses: HttpRequestBuilder                 =
    http("[GET] get head office expenses page")
      .get(s"$baseUrl/$route/head-office-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getIncomeExpenditureSummary6076: HttpRequestBuilder       =
    http("[GET] get income expenditure summary for 6076 page")
      .get(s"$baseUrl/$route/income-expenditure-summary-6076")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postIncomeExpenditureSummary6076: HttpRequestBuilder      =
    http("[POST] post income expenditure summary for 6076 page")
      .post(s"$baseUrl/$route/income-expenditure-summary-6076")
      .formParam("incomeExpenditureSummary6076", "confirmed")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getFinancialYearEndDates: HttpRequestBuilder              =
    http("[GET] get financial year end dates page")
      .get(s"$baseUrl/$route/financial-year-end-dates")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val postFinancialYearEndDates: HttpRequestBuilder             =
    http("[POST] post financial year end dates page")
      .post(s"$baseUrl/$route/financial-year-end-dates")
      .formParamMap(
        Map(
          "financial-year-end[0].date.day"   -> today.day,
          "financial-year-end[0].date.month" -> today.month,
          "financial-year-end[0].date.year"  -> today.year,
          "csrfToken"                        -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))
      .check(headerRegex("Set-Cookie", """mdtp=(.*?);""").saveAs("mdtpCookie"))

  val getTurnOverPage: HttpRequestBuilder                       =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover")
      .check(status.is(200))
      .header(HttpHeaderNames.Cookie, "mdtp=${mdtpCookie}")
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTurnOver6030: HttpRequestBuilder                       =
    http("[GET] get turnover page")
      .get(s"$baseUrl/$route/turnover-6030")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCostOfSales: HttpRequestBuilder                        =
    http("[GET] get cost of sales page")
      .get(s"$baseUrl/$route/cost-of-sales")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTotalPayrollCosts: HttpRequestBuilder                  =
    http("[GET] get total payroll costs page")
      .get(s"$baseUrl/$route/total-payroll-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getVariableOperatingExpenses: HttpRequestBuilder          =
    http("[GET] get Variable Operating Expenses page")
      .get(s"$baseUrl/$route/variable-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getFixedOperatingExpenses: HttpRequestBuilder             =
    http("[GET] get Fixed Operating Expenses page")
      .get(s"$baseUrl/$route/fixed-operating-expenses")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getOtherCosts: HttpRequestBuilder                         =
    http("[GET] get other costs page")
      .get(s"$baseUrl/$route/other-costs")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getIncomeExpenditureSummary: HttpRequestBuilder           =
    http("[GET] get income expenditure summary page")
      .get(s"$baseUrl/$route/income-expenditure-summary")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getUnusualCircumstances: HttpRequestBuilder               =
    http("[GET] get unusual circumstances page")
      .get(s"$baseUrl/$route/unusual-circumstances")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCYAAboutTradingHistory: HttpRequestBuilder             =
    http("[GET] get cya about your trading history")
      .get(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getTotalFuelSold: HttpRequestBuilder                      =
    http("[GET] get total fuel sold page")
      .get(s"$baseUrl/$route/total-fuel-sold")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkeredFuelQuestion: HttpRequestBuilder               =
    http("[GET] get bunkered fuel question page")
      .get(s"$baseUrl/$route/bunkered-fuel-question")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkeredFuelSold: HttpRequestBuilder                   =
    http("[GET] get bunkered fuel sold page")
      .get(s"$baseUrl/$route/bunkered-fuel-sold")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getBunkerFuelCardsDetails: HttpRequestBuilder             =
    http("[GET] get bunkered fuel card details page")
      .get(s"$baseUrl/$route/bunker-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAddAnotherBunkerFuelCardsDetails: HttpRequestBuilder   =
    http("[GET] get add another bunker fuel card details page")
      .get(s"$baseUrl/$route/add-another-bunker-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getCustomerCreditAccounts: HttpRequestBuilder             =
    http("[GET] get customer credit accounts page")
      .get(s"$baseUrl/$route/customer-credit-accounts")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAcceptLowMarginFuelCard: HttpRequestBuilder            =
    http("[GET] get Accept Low Margin Fuel Card")
      .get(s"$baseUrl/$route/accept-low-margin-fuel-card")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getPercentageFromFuelCards: HttpRequestBuilder            =
    http("[GET] get percentage from fuel card page")
      .get(s"$baseUrl/$route/percentage-from-fuel-cards")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getLowMarginFuelCardsDetails: HttpRequestBuilder          =
    http("[GET] get low margin fuel cards details page")
      .get(s"$baseUrl/$route/low-margin-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getAddAnotherLowMarginFuelCardDetails: HttpRequestBuilder =
    http("[GET] get add another low margin fuel cards details page")
      .get(s"$baseUrl/$route/add-another-low-margin-fuel-cards-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getNonFuelTurnOver: HttpRequestBuilder                    =
    http("[GET] get non fuel turn over page")
      .get(s"$baseUrl/$route/non-fuel-turnover")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  val getElectricVehicleChargingPoints: HttpRequestBuilder      =
    http("[GET] get electric vehicle charging points page")
      .get(s"$baseUrl/$route/electric-vehicle-charging-points")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postGrossReceiptsExcludingVat: HttpRequestBuilder         =
    http("[POST] post gross receipts excluding VAT receipts page")
      .post(s"$baseUrl/$route/gross-receipts-excluding-vat")
      .formParamMap(
        Map(
          "grossReceiptsExcludingVAT[0].electricitySales"      -> "123",
          "grossReceiptsExcludingVAT[0].feedInTariff"          -> "123",
          "grossReceiptsExcludingVAT[0].rocBuyout"             -> "123",
          "grossReceiptsExcludingVAT[0].rocRecycle"            -> "123",
          "grossReceiptsExcludingVAT[0].contractForDifference" -> "123",
          "grossReceiptsExcludingVAT[0].capacityMarket"        -> "123",
          "grossReceiptsExcludingVAT[0].balancingServices"     -> "123",
          "grossReceiptsExcludingVAT[0].embeddedBenefits"      -> "123",
          "csrfToken"                                          -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postOtherIncome: HttpRequestBuilder =
    http("[POST] get other income page")
      .post(s"$baseUrl/$route/other-income")
      .formParamMap(
        Map(
          "otherIncomeSeq.turnover[0].otherIncome" -> "124",
          "otherIncomeDetails"                     -> "details",
          "csrfToken"                              -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postCostOfSalesIntermittent: HttpRequestBuilder =
    http("[POST] post cost of sales intermittent page")
      .post(s"$baseUrl/$route/cost-of-sales-intermittent-6076")
      .formParamMap(
        Map(
          "costOfSales6076.[0].importedPower" -> "234",
          "costOfSales6076.[0].TNuoS"         -> "345",
          "costOfSales6076.[0].BSuoS"         -> "456",
          "costOfSales6076.[0].otherSales"    -> "432",
          "otherSalesDetails"                 -> "details",
          "csrfToken"                         -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postStaffCosts: HttpRequestBuilder =
    http("[POST] post staff costs page")
      .post(s"$baseUrl/$route/staff-costs")
      .formParamMap(
        Map(
          "staffCosts.[0].wages"         -> "123",
          "staffCosts.[0].NI"            -> "234",
          "staffCosts.[0].pension"       -> "345",
          "staffCosts.[0].remunerations" -> "345",
          "csrfToken"                    -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postPremiseCosts: HttpRequestBuilder =
    http("[POST] post premises costs page")
      .post(s"$baseUrl/$route/premises-costs")
      .formParamMap(
        Map(
          "premisesCosts.[0].energyAndUtilities"           -> "123",
          "premisesCosts.[0].buildingRepairAndMaintenance" -> "234",
          "premisesCosts.[0].repairsAndRenewalsOfFixtures" -> "456",
          "premisesCosts.[0].rent"                         -> "678",
          "premisesCosts.[0].businessRates"                -> "789",
          "premisesCosts.[0].buildingInsurance"            -> "5678",
          "csrfToken"                                      -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postOperationalExpenses: HttpRequestBuilder =
    http("[POST] post operational expenses")
      .post(s"$baseUrl/$route/operational-expenses")
      .formParamMap(
        Map(
          "operationalExpensesSeq.turnover[0].advertising"    -> "123",
          "operationalExpensesSeq.turnover[0].administration" -> "456",
          "operationalExpensesSeq.turnover[0].insurance"      -> "567",
          "operationalExpensesSeq.turnover[0].legalFees"      -> "679",
          "operationalExpensesSeq.turnover[0].interest"       -> "5678",
          "operationalExpensesSeq.turnover[0].other"          -> "567",
          "otherExpensesDetails"                              -> "456",
          "csrfToken"                                         -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postHeadOfficeExpenses: HttpRequestBuilder =
    http("[POST] post head office expenses page")
      .post(s"$baseUrl/$route/head-office-expenses")
      .formParam("headOfficeExpensesSeq.turnover[0].headOfficeExpenses", "4567")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postWhatYouWillNeed: HttpRequestBuilder =
    http("[POST] post what you will need page")
      .post(s"$baseUrl/$route/what-you-will-need")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postFinancialYearEndDatesSummary(option: String): HttpRequestBuilder =
    http("[GET] get financial year end dates summary page")
      .post(s"$baseUrl/$route/financial-year-end-dates-summary")
      .formParamMap(
        Map(
          "isFinancialYearEndDatesCorrect" -> option,
          "csrfToken"                      -> f"$${csrfToken}"
        )
      )

  def postElectricityGenerated(weeks: Int, electricity: String): HttpRequestBuilder =
    http("[POST] post electricity generated page")
      .post(s"$baseUrl/$route/electricity-generated")
      .formParam("turnover[0].weeks", weeks)
      .formParam("turnover[0].electricityGenerated", electricity)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postTurnOver(
    AlcoholDrinks: Int,
    Food: Int,
    otherReceipts: Int,
    accommodation: Int,
    averageOccupancyRate: Int
  ): HttpRequestBuilder =
    http("[POST] post turnover page")
      .post(s"$baseUrl/$route/turnover")
      .formParamMap(
        Map(
          "0.weeks"                  -> "52",
          "0.alcoholic-drinks"       -> AlcoholDrinks,
          "0.food"                   -> Food,
          "0.other-receipts"         -> otherReceipts,
          "0.accommodation"          -> accommodation,
          "0.average-occupancy-rate" -> averageOccupancyRate,
          "csrfToken"                -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postTurnOver6030(income: String, visitors: String): HttpRequestBuilder =
    http("[POST] post turnover page")
      .post(s"$baseUrl/$route/turnover-6030")
      .formParamMap(
        Map(
          "0.weeks"            -> "52",
          "0.grossIncome"      -> income,
          "totalVisitorNumber" -> visitors,
          "csrfToken"          -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postCostOfSales(accommodation: String, food: String, drinks: String, other: String): HttpRequestBuilder =
    http("[POST] post cost of sales page")
      .post(s"$baseUrl/$route/cost-of-sales")
      .formParamMap(
        Map(
          "costOfSales[0].accommodation" -> accommodation,
          "costOfSales[0].food"          -> food,
          "costOfSales[0].drinks"        -> drinks,
          "costOfSales[0].other"         -> other,
          "csrfToken"                    -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postTotalPayrollCosts(managerAndStaff: String, remuneration: String): HttpRequestBuilder =
    http("[POST] POST total payroll costs page")
      .post(s"$baseUrl/$route/total-payroll-costs")
      .formParamMap(
        Map(
          "totalPayrollCosts[0].managers-and-staff"     -> managerAndStaff,
          "totalPayrollCosts[0].directors-remuneration" -> remuneration,
          "csrfToken"                                   -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postVariableOperatingExpenses(
    energyAndUtilities: String,
    cleaningAndLaundry: String,
    buildingMaintenanceAndRepairs: String,
    fixturesFittingsAndEquipment: String,
    advertisingAndPromotions: String,
    administrationAndSundries: String,
    entertainment: String,
    other: String,
    otherExpensesDetails: String
  ): HttpRequestBuilder =
    http("[POST] post Variable Operating Expenses page")
      .post(s"$baseUrl/$route/variable-operating-expenses")
      .formParamMap(
        Map(
          "variableOperatingExpenses.year[0].energy-and-utilities"             -> energyAndUtilities,
          "variableOperatingExpenses.year[0].cleaning-and-laundry"             -> cleaningAndLaundry,
          "variableOperatingExpenses.year[0].building-maintenance-and-repairs" -> buildingMaintenanceAndRepairs,
          "variableOperatingExpenses.year[0].fixtures-fittings-and-equipment"  -> fixturesFittingsAndEquipment,
          "variableOperatingExpenses.year[0].advertising-and-promotions"       -> advertisingAndPromotions,
          "variableOperatingExpenses.year[0].administration-and-sundries"      -> administrationAndSundries,
          "variableOperatingExpenses.year[0].entertainment"                    -> entertainment,
          "variableOperatingExpenses.year[0].other"                            -> other,
          "otherExpensesDetails"                                               -> otherExpensesDetails,
          "csrfToken"                                                          -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postFixedOperatingExpenses(
    rent: String,
    businessRates: String,
    insurance: String,
    loanInterest: String,
    depreciation: String
  ): HttpRequestBuilder =
    http("[POST] post Fixed Operating Expenses page")
      .post(s"$baseUrl/$route/fixed-operating-expenses")
      .formParamMap(
        Map(
          "fixedOperatingExpenses[0].rent"           -> rent,
          "fixedOperatingExpenses[0].business-rates" -> businessRates,
          "fixedOperatingExpenses[0].insurance"      -> insurance,
          "fixedOperatingExpenses[0].loan-interest"  -> loanInterest,
          "fixedOperatingExpenses[0].depreciation"   -> depreciation,
          "csrfToken"                                -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postOtherCosts(
    contributionsToHeadOffice: String,
    otherCosts: String,
    otherCostsDetails: String
  ): HttpRequestBuilder =
    http("[POST] post other costs page")
      .post(s"$baseUrl/$route/other-costs")
      .formParamMap(
        Map(
          "otherCosts[0].contributionsToHeadOffice" -> contributionsToHeadOffice,
          "otherCosts[0].otherCosts"                -> otherCosts,
          "otherCostDetails"                        -> otherCostsDetails,
          "csrfToken"                               -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postIncomeExpenditureSummary(option: String): HttpRequestBuilder =
    http("[POST] post income expenditure summary page")
      .post(s"$baseUrl/$route/income-expenditure-summary")
      .formParam("incomeExpenditureSummary", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postUnusualCircumstances(details: String): HttpRequestBuilder =
    http("[POST] post unusual circumstances page")
      .post(s"$baseUrl/$route/unusual-circumstances")
      .formParam("unusualCircumstances", details)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postCYAAboutTradingHistory(option: String): HttpRequestBuilder =
    http("[POST] post cya about your trading history")
      .post(s"$baseUrl/$route/check-your-answers-about-the-trading-history")
      .formParam("checkYourAnswersAboutTheTradingHistory", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postTotalFuelSold(answer: String): HttpRequestBuilder =
    http("[POST] post total fuel sold")
      .post(s"$baseUrl/$route/total-fuel-sold")
      .formParam("totalFuelSold-0", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkeredFuelQuestion(option: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel question page")
      .post(s"$baseUrl/$route/bunkered-fuel-question")
      .formParam("bunkeredFuelQuestion", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkeredFuelSold(option: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel sold page")
      .post(s"$baseUrl/$route/bunkered-fuel-sold")
      .formParam("bunkeredFuelSold-0", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postBunkerFuelCardsDetails(answer1: String, answer2: String): HttpRequestBuilder =
    http("[POST] post bunkered fuel card details page")
      .post(s"$baseUrl/$route/bunker-fuel-cards-details")
      .formParam("name", answer1)
      .formParam("handlingFee", answer2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAddAnotherBunkerFuelCardsDetails(option: String): HttpRequestBuilder =
    http("[POST] post add another bunker fuel card details page")
      .post(s"$baseUrl/$route/add-another-bunker-fuel-cards-details")
      .formParam("addAnotherBunkerFuelCardsDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postCustomerCreditAccounts(option: String): HttpRequestBuilder =
    http("[POST] post customer credit accounts page")
      .post(s"$baseUrl/$route/customer-credit-accounts")
      .formParam("customerCreditAccounts-0", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAcceptLowMarginFuelCard(option: String): HttpRequestBuilder =
    http("[POST] post accept low Margin Fuel Card")
      .post(s"$baseUrl/$route/accept-low-margin-fuel-card")
      .formParam("acceptLowMarginFuelCard", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postPercentageFromFuelCards(answer: String): HttpRequestBuilder =
    http("[POST] post percentage from fuel card page")
      .post(s"$baseUrl/$route/percentage-from-fuel-cards")
      .formParam("percentageFromFuelCards-0", answer)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postLowMarginFuelCardsDetails(answer1: String, answer2: String): HttpRequestBuilder =
    http("[POST] post low margin fuel cards details page")
      .post(s"$baseUrl/$route/low-margin-fuel-cards-details")
      .formParam("name", answer1)
      .formParam("handlingFee", answer2)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postAddAnotherLowMarginFuelCardDetails(option: String): HttpRequestBuilder =
    http("[POST] post add another low margin fuel cards details page")
      .post(s"$baseUrl/$route/add-another-low-margin-fuel-cards-details")
      .formParam("addAnotherLowMarginFuelCardsDetails", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  def postNonFuelTurnOver(
    shop: String,
    carWash: String,
    jetWash: String,
    lottery: String,
    payPointOrZone: String,
    otherIncome: String
  ): HttpRequestBuilder =
    http("[POST] post non fuel turn over page")
      .post(s"$baseUrl/$route/non-fuel-turnover")
      .formParamMap(
        Map(
          "turnover[0].shop"           -> shop,
          "turnover[0].carWash"        -> carWash,
          "turnover[0].jetWash"        -> jetWash,
          "turnover[0].lottery"        -> lottery,
          "turnover[0].payPointOrZone" -> payPointOrZone,
          "turnover[0].otherIncome"    -> otherIncome,
          "csrfToken"                  -> f"$${csrfToken}"
        )
      )
      .check(status.is(303))

  def postElectricVehicleChargingPoints(option: String, answer: String): HttpRequestBuilder =
    http("[POST] post electric vehicle charging points page")
      .post(s"$baseUrl/$route/electric-vehicle-charging-points")
      .formParam("electricVehicleChargingPoints", option)
      .formParam("spacesOrBays", answer)

  val TradingHistorySection: Seq[HttpRequestBuilder] = Seq(
    getTaskListPage,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6015: Seq[HttpRequestBuilder] = Seq(
    getTaskListPage,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCostOfSales,
    postCostOfSales("110", "11", "23", "24"),
    getTotalPayrollCosts,
    postTotalPayrollCosts("33", "10"),
    getVariableOperatingExpenses,
    postVariableOperatingExpenses("11", "23", "345", "123", "34", "0", "0", "23", "other expense details"),
    getFixedOperatingExpenses,
    postFixedOperatingExpenses("2300", "0", "50", "11", "23"),
    getOtherCosts,
    postOtherCosts("124", "400", "other details"),
    getIncomeExpenditureSummary,
    postIncomeExpenditureSummary("confirmed"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6016: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOverPage,
    postTurnOver(1234, 50, 2340, 230, 30),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6020: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDatesSummary,
    postFinancialYearEndDatesSummary("true"),
    getTotalFuelSold,
    postTotalFuelSold("100"),
    getBunkeredFuelQuestion,
    postBunkeredFuelQuestion("yes"),
    getBunkeredFuelSold,
    postBunkeredFuelSold("50"),
    getBunkerFuelCardsDetails,
    postBunkerFuelCardsDetails("shell", "23.5"),
    getAddAnotherBunkerFuelCardsDetails,
    postAddAnotherBunkerFuelCardsDetails("no"),
    getCustomerCreditAccounts,
    postCustomerCreditAccounts("30"),
    getAcceptLowMarginFuelCard,
    postAcceptLowMarginFuelCard("yes"),
    getPercentageFromFuelCards,
    postPercentageFromFuelCards("100"),
    getLowMarginFuelCardsDetails,
    postLowMarginFuelCardsDetails("shell", "23.5"),
    getAddAnotherLowMarginFuelCardDetails,
    postAddAnotherLowMarginFuelCardDetails("no"),
    getNonFuelTurnOver,
    postNonFuelTurnOver("22", "223", "123", "67", "789", "67"),
    getElectricVehicleChargingPoints,
    postElectricVehicleChargingPoints("yes", "12"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6030: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDates,
    postFinancialYearEndDates,
    getTurnOver6030,
    postTurnOver6030("1234", "50"),
    getUnusualCircumstances,
    postUnusualCircumstances("Details of unusual circumstances"),
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6076: Seq[HttpRequestBuilder] = Seq(
    getWhatYouWillNeed,
    postWhatYouWillNeed,
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDatesSummary,
    postFinancialYearEndDatesSummary("true"),
    getElectricityGenerated,
    postElectricityGenerated(26, "10KW"),
    getGrossReceiptsExcludingVat,
    postGrossReceiptsExcludingVat,
    getOtherIncome,
    postOtherIncome,
    getCostOfSalesIntermittent,
    postCostOfSalesIntermittent,
    getStaffCosts,
    postStaffCosts,
    getPremisesCosts,
    postPremiseCosts,
    getOperationalExpenses,
    postOperationalExpenses,
    getHeadOfficeExpenses,
    postHeadOfficeExpenses,
    getIncomeExpenditureSummary6076,
    postIncomeExpenditureSummary6076,
    getCYAAboutTradingHistory,
    postCYAAboutTradingHistory("yes")
  )
  val TradingHistorySectionFor6045: Seq[HttpRequestBuilder] = Seq(
    getAboutYourTradingHistory,
    postAboutYourTradingHistory,
    getFinancialYearEnd,
    postFinancialYearEnd,
    getFinancialYearEndDatesSummary,
    postFinancialYearEndDatesSummary("true"),
    getFinancialYears,
    postFinancialYears
  )
  val StaticCaravansSection: Seq[HttpRequestBuilder] = Seq(
    getStaticCaravans,
    postStaticCaravans,
    getAreCaravansOpenAllYear,
    postAreCaravansOpenAllYear,
    getGrossReceiptsFleetCaravan,
    postGrossReceiptsFleetCaravan,
    getSingleCaravansOwnedByOperator,
    postSingleCaravansOwnedByOperator,
    getSingleCaravansSublet,
    postSingleCaravansSublet,
    getSingleCaravanAgeCategories,
    postSingleCaravanAgeCategories,
    getTwinUnitCaravansOwnedByOperator,
    postTwinUnitCaravansOwnedByOperator,
    getTwinUnitCaravansSubLet,
    postTwinUnitCaravansSubLet,
    getTwinUnitCaravansAgeCategories,
    postTwinUnitCaravansAgeCategories,
    getCaravansSiteCapacity,
    postCaravansSiteCapacity,
    getCaravansPerService,
    postCaravansPerService,
    getCaravansAnnualPitchFee,
    postCaravansAnnualPitchFee,
    getCheckYourAnswersAboutTheTradingHistory
  )
  val OtherHolidayAccommodation: Seq[HttpRequestBuilder] = Seq(
    getOtherHolidayAccommodation,
    postOtherHolidayAccommodation,
    getOtherHolidayAccommodationOpenAllYear,
    postOtherHolidayAccommodationOpenAllYear,
    getGrossReceiptsLettingUnits,
    postGrossReceiptsLettingUnits,
    getGrossReceiptsSubLetUnits,
    postGrossReceiptsSubLetUnits,
    getTotalSiteCapacity,
    postTotalSiteCapacity,
    getCheckYourAnswersOtherHolidayAccommodation
  )
  val TouringAndTentingPitches: Seq[HttpRequestBuilder] = Seq(
    getTentingPitchesOnSite,
    postTentingPitchesOnSite,
    getTentingPitchesAllYear,
    postTentingPitchesAllYear,
    getPitchesForCaravans,
    postPitchesForCaravans,
    getPitchesForGlamping,
    postPitchesForGlamping,
    getRallyAreas,
    postRallyAreas,
    getTentingPitchesTotal,
    postTentingPitchesTotal,
    getTentingPitchesCertificated,
    postTentingPitchesCertificated,
    getCheckYourAnswersTentingPitches
  )
  val AdditionActivitiesOnSite: Seq[HttpRequestBuilder] = Seq(
    getAdditionActivitiesOnSite,
    postAdditionActivitiesOnSite,
    getAdditionalShops,
    postAdditionalShops,
    getAdditionalCatering,
    postAdditionalCatering,
    getAdditionalBarsClubs,
    postAdditionalBarsClubs,
    getAdditionalAmusements,
    postAdditionalAmusements,
    getAdditionalMisc,
    postAdditionalMisc,
    getCheckYourAnswersAdditionalActivities
  )

}

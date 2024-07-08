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

package uk.gov.hmrc.perftests.tctr.simulation

import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.tctr.requests.{AboutPropertyRequests, AdditionalInformationRequests, FranchiseOrLettingsRequests, LeaseOrAgreementRequests, TradingHistoryRequests, tctrRequests}
import uk.gov.hmrc.perftests.tctr.simulation.setup.SetupSimulation

class tctrSimulation extends PerformanceTestRunner with SetupSimulation {

  def submit6011VacantProperty: Seq[HttpRequestBuilder] = tctrRequests.submitVacantProperty("6011")
  val submit6011ForNotConnectedToProperty: Seq[HttpRequestBuilder] = tctrRequests.submitForNotConnectedToProperty("6011")

  val aboutYouAndPropertySectionFor6011: Seq[HttpRequestBuilder] = AboutPropertyRequests.aboutYouAndPropertySection("6011")
  val aboutYouAndPropertySectionFor6010: Seq[HttpRequestBuilder] = AboutPropertyRequests.aboutYouAndPropertySection("6010")
  val aboutYouAndPropertySectionFor6015: Seq[HttpRequestBuilder] = AboutPropertyRequests.aboutYouAndPropertySection6015("6015")
  val aboutYouAndPropertySectionFor6016: Seq[HttpRequestBuilder] = AboutPropertyRequests.aboutYouAndPropertySection6016("6016")

  setup("vacant-property-submission-6011", "submit vacant property journey")
  .withRequests(submit6011VacantProperty:_*)

  setup("Not-connected-to-property-submission-6011", "submit not connected to property journey")
  .withRequests(submit6011ForNotConnectedToProperty:_*)

  setup("No-reference-number", "Request reference number journey")
  .withRequests(tctrRequests.requestReferenceNumberJourney:_*)

  setup("Download-pdf-version", "Download pdf version journey")
  .withRequests(tctrRequests.downloadPdfVersion:_*)

  //----6011------

  setup("About-property-6011", "Submit about you and your property section")
    .withRequests(aboutYouAndPropertySectionFor6011:_*)

  setup("Trading-History-6011", "Submit Trading history section")
    .withRequests(TradingHistoryRequests.TradingHistorySection:_*)

  setup("Franchise-or-Lettings-6011", "Submit Franchise or Lettings section")
    .withRequests(FranchiseOrLettingsRequests.franchiseOrLettingsSection:_*)

  setup("Lease-or-Agreement-6011", "Submit Lease or agreement section")
    .withRequests(LeaseOrAgreementRequests.leaseOrAgreementSectionFor6011:_*)

  setup("Additional-information-6011", "Submit Additional information section")
    .withRequests(AdditionalInformationRequests.additionalInformationSection:_*)

  //----6010------

  setup("About-property-6010", "Submit about you and your property section")
    .withRequests(aboutYouAndPropertySectionFor6010: _*)

  setup("Trading-History-6010", "Submit Trading history section")
    .withRequests(TradingHistoryRequests.TradingHistorySection: _*)

  setup("Franchise-or-Lettings-6010", "Submit Franchise or Lettings section")
    .withRequests(FranchiseOrLettingsRequests.franchiseOrLettingsSection: _*)

  setup("Lease-or-Agreement-6010", "Submit Lease or agreement section")
    .withRequests(LeaseOrAgreementRequests.leaseOrAgreementSectionFor6010: _*)

  setup("Additional-information-6010", "Submit Additional information section")
    .withRequests(AdditionalInformationRequests.additionalInformationSection: _*)

  //----6015------
  setup("About-property-6015", "Submit about you and your property section")
    .withRequests(aboutYouAndPropertySectionFor6015: _*)

  setup("Trading-History-6015", "Submit Trading history section")
    .withRequests(TradingHistoryRequests.TradingHistorySectionFor6015:_*)

  setup("Franchise-or-Lettings-6015","Submit Franchise or Lettings section")
    .withRequests(FranchiseOrLettingsRequests.franchiseOrLettingsSectionFor6015: _*)

  setup("Lease-or-Agreement-6015", "Submit Lease or agreement section")
    .withRequests(LeaseOrAgreementRequests.leaseOrAgreementSectionFor6015: _*)

  setup("Additional-information-6015", "Submit Additional information section")
    .withRequests(AdditionalInformationRequests.additionalInformationSection: _*)

  //----6016-----
  setup("About-property-6016","Submit about you and your property section")
    .withRequests(aboutYouAndPropertySectionFor6016: _*)

  setup("Trading-History-6016", "Submit Trading history section")
    .withRequests(TradingHistoryRequests.TradingHistorySectionFor6016: _*)



  runSimulation()
}

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

package uk.gov.hmrc.perftests.tctr.simulation

import io.gatling.http.request.builder.HttpRequestBuilder
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.tctr.requests.{AboutPropertyRequests, AdditionalInformationRequests, FranchiseOrLettingsRequests, LeaseOrAgreementRequests, TradingHistoryRequests, tctrRequests}
import uk.gov.hmrc.perftests.tctr.simulation.setup.SetupSimulation

class tctrSimulation extends PerformanceTestRunner with SetupSimulation {

  def submit6011VacantProperty: Seq[HttpRequestBuilder] = tctrRequests.submitVacantProperty("6011")
  val submit6011ForNotConnectedToProperty: Seq[HttpRequestBuilder] = tctrRequests.submitForNotConnectedToProperty("6011")
  val aboutYouAndPropertySectionFor6011: Seq[HttpRequestBuilder] = AboutPropertyRequests.aboutYouAndPropertySection("6011")

  setup("vacant-property-submission-6011", "submit vacant property journey")
  .withRequests(submit6011VacantProperty:_*)

  setup("Not-connected-to-property-submission-6011", "submit not connected to property journey")
  .withRequests(submit6011ForNotConnectedToProperty:_*)

  setup("No-reference-number", "Request reference number journey")
  .withRequests(tctrRequests.requestReferenceNumberJourney:_*)

  setup("Download-pdf-version", "Download pdf version journey")
  .withRequests(tctrRequests.downloadPdfVersion:_*)

  setup("About-property-6011", "Submit about you and your property section")
    .withRequests(aboutYouAndPropertySectionFor6011:_*)

  setup("Trading-History-6011", "Submit Trading history section")
    .withRequests(TradingHistoryRequests.TradingHistorySectionFor6011:_*)

  setup("Franchise-or-Lettings-6011", "Submit Franchise or Lettings section")
    .withRequests(FranchiseOrLettingsRequests.franchiseOrLettingsSectionFor6011:_*)

  setup("Lease-or-Agreement-6011", "Submit Lease or agreement section")
    .withRequests(LeaseOrAgreementRequests.leaseOrAgreementSectionFor6011:_*)

  setup("Additional-information-6011", "Submit Additional information section")
    .withRequests(AdditionalInformationRequests.additionalInformationSectionFor6011:_*)

  runSimulation()
}

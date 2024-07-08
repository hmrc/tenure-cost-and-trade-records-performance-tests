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
import uk.gov.hmrc.perftests.tctr.requests.tctrRequests.{getTaskListPage, _}

object AdditionalInformationRequests extends HttpConfiguration with servicesConfig {

  val getFurtherInformationOrRemarks: HttpRequestBuilder =
    http("[GET] get further information or remarks")
      .get(s"$baseUrl/$route/further-information-or-remarks")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postFurtherInformationOrRemarks(information: String): HttpRequestBuilder =
    http(s"[POST] post  further information or remarks")
      .post(s"$baseUrl/$route/further-information-or-remarks")
      .formParam("furtherInformationOrRemarks", information)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getContactDetailQuestion: HttpRequestBuilder =
    http("[GET] get contact details question page")
      .get(s"$baseUrl/$route/contact-details-question")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postContactDetailQuestion(option: String): HttpRequestBuilder =
    http("[POST] post contact details question page")
      .post(s"$baseUrl/$route/contact-details-question")
      .formParam("contactDetailsQuestion", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getAlternateContactDetails: HttpRequestBuilder =
    http("[GET] get alternate contact details page")
      .get(s"$baseUrl/$route/alternate-contact-details")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postAlternateContactDetails(name: String, phone: String, email: String, buildingNameNumber: String, town: String, postcode: String): HttpRequestBuilder =
    http("[POST] post alternate contact details page")
      .post(s"$baseUrl/$route/alternate-contact-details")
      .formParamMap(Map(
        "alternativeContactFullName" -> name,
        "alternativeContactDetails.phone" -> phone,
        "alternativeContactDetails.email" -> email,
        "alternativeContactAddress.buildingNameNumber" -> buildingNameNumber,
        "alternativeContactAddress.town" -> town,
        "alternativeContactAddress.postcode" -> postcode,
        "csrfToken" -> f"$${csrfToken}"
      ))
      .check(status.is(303))

  val getCYAAdditionalInformation: HttpRequestBuilder =
    http("[GET] get cya for additional information")
      .get(s"$baseUrl/$route/check-your-answers-additional-information")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postCYAAdditionalInformation(option: String): HttpRequestBuilder =
    http("[POST] post cya for additional information ")
      .post(s"$baseUrl/$route/check-your-answers-additional-information")
      .formParam("checkYourAnswersAdditionalInformation", option)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val postTaskList: HttpRequestBuilder =
    http("[POST] post submit on the tasklist page")
      .post(s"$baseUrl/$route/declaration")
      .formParam("continue_button", "continue_button")
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))

  val getConfirmationPage: HttpRequestBuilder =
    http("[GET] get confirmation page")
      .get(s"$baseUrl/$route/confirmation")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))


  val additionalInformationSection: Seq[HttpRequestBuilder] = Seq(
    getFurtherInformationOrRemarks,
    postFurtherInformationOrRemarks("Further information and remarks"),
    getCYAAdditionalInformation,
    postCYAAdditionalInformation("yes"),
    getTaskListPage,
    postTaskList,
    getConfirmationPage
  )

}

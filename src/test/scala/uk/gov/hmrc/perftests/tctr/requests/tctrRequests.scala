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
import uk.gov.hmrc.performance.conf.{HttpConfiguration, ServicesConfiguration}

object tctrRequests extends HttpConfiguration with ServicesConfiguration {

  val baseUrl: String = baseUrlFor("tenure-cost-and-trade-records-frontend")
  val route = "/send-trade-and-cost-information"

  val getHomePage: HttpRequestBuilder =
    http("[GET] Get send trade and cost information start page")
      .get(s"$baseUrl/$route")
      .check(status.is(200))
      .check(
        checkIf(session => session.contains("csrfToken")){
          css("input[name=csrfToken]", "value").saveAs("csrfToken")
        }
      )

  val getLoginPage: HttpRequestBuilder =
    http("[GET] Get send trade and cost information login page")
      .get(s"$baseUrl/$route/login")
      .check(status.is(200))
      .check(css("input[name=csrfToken]", "value").saveAs("csrfToken"))

  def postLoginPage(postcode:String) : HttpRequestBuilder =
    http("[POST] Login with reference number and postcode page")
      .post(s"$baseUrl/$route/login")
      .formParam("referenceNumber","#{referenceNumberFor6011}")
      .formParam("postcode",postcode)
      .formParam("csrfToken", f"$${csrfToken}")
      .check(status.is(303))
      println("#{referenceNumberFor6011}")


  val submit6011Form: Seq[HttpRequestBuilder] = Seq(
    getHomePage,
    getLoginPage,
//    postLoginPage("BN12 4AX")
  )

}

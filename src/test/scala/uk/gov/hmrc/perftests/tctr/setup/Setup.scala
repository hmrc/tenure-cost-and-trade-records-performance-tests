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

package uk.gov.hmrc.perftests.tctr.setup

import io.gatling.core.Predef._
import io.gatling.core.action.builder.ActionBuilder
import uk.gov.hmrc.perftests.tctr.requests.tctrRequests.dynamicReferenceNumber

import scala.Console.println

object Setup {

  private def setupSessionWithRefNumber(form: String, session: Session): Session = {
    val referenceNumber = dynamicReferenceNumber(form)
    println(s"reference number is" + referenceNumber)
    session.setAll(
      List(
        "referenceNumber" -> dynamicReferenceNumber(form)
      )
    )
  }

//  def setupSession(form: String): List[ActionBuilder] =
//    exec {
//      (session: Session) =>
//        setupSessionWithRefNumber(form, session)
//    }.actionBuilders

  // Function to set up session with reference number in web-test-prep phase
  def setupSession(form: String): List[ActionBuilder] = {
    exec { session =>
      val referenceNumber = dynamicReferenceNumber(form) // Generate reference number for form 1234
      println(s"Setting reference number in session: $referenceNumber") // Print for debugging
      session.set("referenceNumber", referenceNumber) // Store reference number in session
    }.actionBuilders
  }

}

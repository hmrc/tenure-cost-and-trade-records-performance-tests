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

object Setup {

  private def setupSession(form: String, session: Session): Session =
    session.setAll(
      List(
        "referenceNumber" -> dynamicReferenceNumber(form),
//        "referenceNumberFor6011" -> dynamicReferenceNumber("6011"),
//        "referenceNumberFor6015" -> dynamicReferenceNumber("6015"),
//        "referenceNumberFor6016" -> dynamicReferenceNumber("6016")
      )
    )

  def setupSession(form: String): List[ActionBuilder] =
    exec {
      (session: Session) =>
        setupSession(form, session)
    }.actionBuilders
}

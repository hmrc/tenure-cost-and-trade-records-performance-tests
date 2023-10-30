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

package uk.gov.hmrc.perftests.tctr.config

import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.tctr.model.ReferenceNumberGenerator
import utils.DateUtils._

trait servicesConfig extends ServicesConfiguration {

  val baseUrl: String = baseUrlFor("tenure-cost-and-trade-records-frontend")
  val route = "/send-trade-and-cost-information"

  val generator = new ReferenceNumberGenerator()
  def dateTime: String = now.format(formatter)

  def dynamicReferenceNumber(form: String): Long = {
    form match {
      case "6010" => generator.generateReferenceNumberFor6010
      case "6011" => generator.generateReferenceNumberFor6011
      case "6015" => generator.generateReferenceNumberFor6015
      case "6016" => generator.generateReferenceNumberFor6016
      case _ => throw new IllegalArgumentException(s"$form is not a valid form")
    }
  }


}

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

package uk.gov.hmrc.perftests.tctr.model

import scala.util.Random

class ReferenceNumberGenerator {
  def generateReferenceNumberFor6011: Long = {
    val randomLastThreeDigits = 10001 + Random.nextInt(999) // Generates a random number between 10001 and 10999
    99996000000L + randomLastThreeDigits // Combines the random digits with the fixed prefix
  }
}


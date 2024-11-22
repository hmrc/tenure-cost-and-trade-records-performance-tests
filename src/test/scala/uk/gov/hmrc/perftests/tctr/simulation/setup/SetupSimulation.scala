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

package uk.gov.hmrc.perftests.tctr.simulation.setup

import io.gatling.core.action.builder.ActionBuilder
import uk.gov.hmrc.performance.simulation.PerformanceTestRunner
import uk.gov.hmrc.perftests.tctr.setup.Setup

trait SetupSimulation {
  this: PerformanceTestRunner =>
  def setupSessionFor6011: List[ActionBuilder] = Setup.setupSession("6011")
  def setupSessionFor6010: List[ActionBuilder] = Setup.setupSession("6010")
  def setupSessionFor6015: List[ActionBuilder] = Setup.setupSession("6015")
  def setupSessionFor6016: List[ActionBuilder] = Setup.setupSession("6016")
  def setupSessionFor6020: List[ActionBuilder] = Setup.setupSession("6020")
  def setupSessionFor6030: List[ActionBuilder] = Setup.setupSession("6030")
  def setupSessionFor6076: List[ActionBuilder] = Setup.setupSession("6076")

  setup("web-test-prep-for-6011", "Prepare for test") withActions (setupSessionFor6011: _*)
  setup("web-test-prep-for-6010", "Prepare for test") withActions (setupSessionFor6010: _*)
  setup("web-test-prep-for-6015", "Prepare for test") withActions (setupSessionFor6015: _*)
  setup("web-test-prep-for-6016", "Prepare for test") withActions (setupSessionFor6016: _*)
  setup("web-test-prep-for-6020", "Prepare for test") withActions (setupSessionFor6020: _*)
  setup("web-test-prep-for-6030", "Prepare for test") withActions (setupSessionFor6030: _*)
  setup("web-test-prep-for-6076", "Prepare for test") withActions (setupSessionFor6076: _*)

}
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

package uk.gov.hmrc.perftests.tctr.mongo

import uk.gov.hmrc.performance.conf.ServicesConfiguration

trait DropDatabase extends ServicesConfiguration {

  private val movementsUrl: String = {
    //TODO: request the testOnly url to drop the db 
    val endpoint = "test-only/"
    s"${baseUrlFor("tenure-cost-and-trade-records")}/$endpoint"
  }

  def dropCollections(): Unit = {
    dropCollection("submittedUrl")
  }

  def dropCollection(url: String): Unit = {
    import sys.process._

    val cmd: Seq[String] = Seq("curl", "-f", "-X", "DELETE", url)

    try {
      cmd.!!
      ()
    } catch {
      case e: Throwable => println(s"Error dropping database with command '${cmd.mkString(" ")}': ${e.getMessage}")
    }
  }
}

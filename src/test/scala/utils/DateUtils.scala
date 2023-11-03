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

package utils

import java.time.{Instant, LocalDateTime, ZoneId, ZonedDateTime}
import java.time.format.DateTimeFormatter

object DateUtils {

  val now: ZonedDateTime = ZonedDateTime.ofInstant(Instant.now(), ZoneId.systemDefault())
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
  val financialYearEndFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

  val today: LocalDateTime = LocalDateTime.now

  val nextMonth: LocalDateTime = today.plusMonths(1)
  val pastMonth: LocalDateTime = today.minusMonths(1)
  val pastDay: LocalDateTime = today.minusDays(1)
  val pastYear: LocalDateTime = today.minusYears(1)
  val nextYear: LocalDateTime = today.plusYears(1)

  implicit class RichLocalDateTime(localDateTime: LocalDateTime) {
    val day: String    = localDateTime.getDayOfMonth.toString
    val month: String  = localDateTime.getMonthValue.toString
    val year: String   = localDateTime.getYear.toString
    val hour: String   = localDateTime.getHour.toString
    val minute: String = localDateTime.getMinute.toString
  }

}

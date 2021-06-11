package subtask1

import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {

        val dateParser = SimpleDateFormat("dd-MM-yyyy")

        var date: Date? = null

        try {
            date = dateParser.parse("$day-$month-$year")
        } catch (e: ParseException) {
            return "Такого дня не существует"
        }

        val dayInMonth = SimpleDateFormat("d").format(date!!)
        val monthInYear = SimpleDateFormat("M").format(date!!)

        if ( dayInMonth != day) return "Такого дня не существует"
        if ( monthInYear != month) return "Такого дня не существует"

        val dateFormatter = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))

        val formattedDate = dateFormatter.format(date!!) // 27 июля 2020 04:28:06

        return formattedDate

    }
}

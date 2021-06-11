package subtask3

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import kotlin.Comparator
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {

        if ( blockB == String::class ) {
            return resultForStrings(blockA)
        }
        if ( blockB == Int::class ) {
            return resultForInt(blockA)
        }
        if ( blockB == LocalDate::class ) {
            return resultForDate(blockA)
        }

        return ClassCastException()

    }

    private fun resultForStrings(blockA: Array<*>): String {

        val resArray = blockA.filterIsInstance<String>()
        return resArray.joinToString(prefix = "", postfix = "", separator = "")
    }

    private fun resultForInt(blockA: Array<*>): Int {

        val resArray = blockA.filterIsInstance<Int>()
        return resArray.sum()
    }

    private fun resultForDate(blockA: Array<*>): String {

        val resArray = blockA.filterIsInstance<LocalDate>()

        val maxDate = resArray.maxWith(
            Comparator { date1, date2 ->
                when {
                   (date1.year > date2.year ) -> 1
                   (date1.month > date2.month ) -> 1
                   (date1.dayOfMonth > date2.dayOfMonth ) -> 1
                    else -> 0
                }
            }
        )

        val dateParser= SimpleDateFormat("dd-MM-yyyy")
        val resDate = dateParser.parse("${maxDate?.dayOfMonth}-${maxDate?.monthValue}-${maxDate?.year}")

        val dateFormatter = SimpleDateFormat("dd.MM.yyyy")
        return dateFormatter.format(resDate)

    }

}

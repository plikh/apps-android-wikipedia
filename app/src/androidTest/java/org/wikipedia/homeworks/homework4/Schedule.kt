package org.wikipedia.homeworks.homework4

import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Schedule {

    private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")
    private var currentDay: Days? = null

    private fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
        scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
    }

    fun schedule(func: Schedule.() -> Unit) {
        func()
    }

    fun day(day: Days, func: Schedule.() -> Unit) = setDay(day, func)

    private fun setDay(day: Days, func: Schedule.() -> Unit) {
        currentDay = day
        func()
        currentDay = null
    }


    infix fun String.rangeTo(end: String): Pair<LocalTime, LocalTime> =
        LocalTime.parse(this, timeFormatter) to LocalTime.parse(end, timeFormatter)

    infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
        currentDay?.let { day ->
            addSchedule(day, ScheduleEntity(lesson, this.first, this.second))
        } ?: throw IllegalStateException("Day must be set before scheduling lessons")
    }


    override fun toString(): String {
        return scheduleOfWeek.toSortedMap()
            .map { (day, list) ->
                list.sortedBy { it.startTime }
                    .joinToString("\n") {
                        "%-15s${it.startTime.format(timeFormatter)} - ${
                            it.endTime.format(
                                timeFormatter
                            )
                        }".format("\t${it.lesson}:")
                    }.let {
                        "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
                    }
            }.joinToString("\n\n")
    }
}

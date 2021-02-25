package com.crystal.devs.hashcode2021

import java.io.PrintWriter
import kotlin.math.ln
import kotlin.math.max
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun computeSolution(parsedInput: ParsedInput): Solution {
    var numberOfCarsByIntersection = parsedInput.intersections.map { it.key to it.value.streets.map { it.name to 0 }.toMap().toMutableMap() }.toMap()
    val startingStreets = parsedInput.cars.map { it.path.first() }.toSet()
    parsedInput.cars.map { it.path.dropLast(1)}.flatten()
            .forEach { val intersection = numberOfCarsByIntersection[parsedInput.streets[it]!!.to]!!
                intersection[it] = intersection[it]!! + 1 }
    numberOfCarsByIntersection = numberOfCarsByIntersection.map { it.key to it.value.filter { it.value > 0 }.toMutableMap() }
            .toMap().filter { it.value.isNotEmpty() }


    val schedules = numberOfCarsByIntersection.map {
        val totalOfValues = it.value.map { it.value }.sum()
        val nbOfIncomingStreet = it.value.size.toFloat()

        IntersectionSchedule(it.key,
            it.value.map {
                TrafficLightSchedule( max(1, (ln(it.value.toFloat()) * 1.5).roundToInt()), it.key) }
                    .sortedBy {
                        if(startingStreets.contains(it.streetName)) {
                            0
                        } else {
                            1
                        }
                    }
        )
    }

    return Solution(schedules)
}

data class Solution(val intersectionsSchedules: List<IntersectionSchedule>) {
    fun computeScore() = 1;

    fun print(out: PrintWriter) {
        out.println(intersectionsSchedules.size)
        intersectionsSchedules.forEach { it.print(out) }
    }
}

data class IntersectionSchedule(val intersectionNumber: Int, val trafficLightSchedules: List<TrafficLightSchedule>) {
    fun print(out: PrintWriter) {
        out.println(intersectionNumber)
        out.println(trafficLightSchedules.size)
        trafficLightSchedules.forEach { it.print(out) }
    }
}

data class TrafficLightSchedule(val duration: Int, val streetName: String) {
    fun print(out: PrintWriter) {
        out.println("$streetName $duration")
    }
}

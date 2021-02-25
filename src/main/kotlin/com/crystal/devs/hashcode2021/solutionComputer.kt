package com.crystal.devs.hashcode2021

import java.io.PrintWriter

fun computeSolution(parsedInput: ParsedInput): Solution {
    return Solution(emptyList())
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

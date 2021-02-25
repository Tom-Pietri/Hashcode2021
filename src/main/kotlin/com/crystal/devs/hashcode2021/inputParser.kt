package com.crystal.devs.hashcode2021

fun parseInput(input: List<String>): ParsedInput {
    val (duration, _, streetsNumber, carsNumber, scorePerCar) = input[0].split(" ").map { it.toInt() }

    val streets = input.subList(1, streetsNumber + 1).map {
        val (from, to, name, length) = it.split(" ")
        Street(name, length.toInt(), from.toInt(), to.toInt())
    }.map { it.name to it }.toMap()

    val cars = input.subList(streetsNumber + 1, input.size).map {
        val split = it.split(" ")
        val carStreets = split.subList(1, split.size)
        Car(carStreets.toMutableList(), streets.get(carStreets[0])!!)
    }

    return ParsedInput(simulationDurationInSeconds = duration,
            scorePerCar = scorePerCar,
            streets = streets,
            cars = cars)
}

data class ParsedInput(val simulationDurationInSeconds: Int,
                       val scorePerCar: Int,
                       val streets: Map<String, Street>,
                       val cars: List<Car>)

data class Street(val name: String, val length: Int, var from: Int, var to: Int)

data class Car(val path: MutableList<String>, val currentStreet: Street)
package com.crystal.devs.hashcode2021

fun runInput(input: List<String>, inputName: String): Int {
    val parsedInput = parseInput(input)
    val solution = computeSolution(parsedInput)
    writeSolution(solution, inputName)
    return solution.computeScore()
}
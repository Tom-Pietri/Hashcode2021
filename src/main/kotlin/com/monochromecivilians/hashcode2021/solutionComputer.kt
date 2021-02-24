package com.monochromecivilians.hashcode2021

fun computeSolution(parsedInput: ParsedInput): Solution {
    return Solution(parsedInput)
}

data class Solution(val solution: ParsedInput) {
    fun computeScore() = 1;
}
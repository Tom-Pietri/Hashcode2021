package com.monochromecivilians.hashcode2020

fun computeSolution(parsedInput: ParsedInput): Solution {
    return Solution(parsedInput)
}

data class Solution(val solution: ParsedInput) {
    fun computeScore() = 1;
}
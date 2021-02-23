package com.monochromecivilians.hashcode2020

fun parseInput(input: List<String>): ParsedInput {
    return ParsedInput(input = input)
}

data class ParsedInput(val input : List<String>);
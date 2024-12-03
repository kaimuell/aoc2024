package org.example

import java.io.File

fun main() {
    println("Day3 Part1 : ${ Day3("src/main/resources/3_1").part1() }")

}


class Day3(val file: String) {

    fun part1():Int{
        val input = readFile()
        return searchAndMultiply(input)
    }

    fun readFile(): List<String> {
      return File(file).bufferedReader().lines().toList() ?: listOf()
    }

    fun searchAndMultiply(input: List<String>): Int {
        return scanLine(input.joinToString())
    }

    fun scanLine(line: String): Int {
        val regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)".toRegex()
        var result = regex.find(line)
        var erg = 0
        while (result != null){
            val num1 = parseOrZero(result.groupValues[1])
            val num2 = parseOrZero((result.groupValues[2]))
            erg += num1 * num2

            result = result.next()
            }
        return erg;
    }

    private fun parseOrZero(s: String): Int {
        try {
            return s.toInt()
        } catch (e: Exception){
            return 0;
        }
    }


}
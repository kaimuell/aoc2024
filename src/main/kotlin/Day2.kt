package org.example

import java.io.File


fun main() {
    println("Day2 Part1 : ${ Day2("src/main/resources/2_1").part1() }")
    println("Day2 Part2 : ${ Day2("src/main/resources/2_1").part2() }")
}


class Day2 (val file : String) {



    fun readFile(): List<List<Int>>? {
        val lines = File(file).bufferedReader().lines()
        return lines.map { it.split(' ').map { it.toInt() }.toList() }.toList()
    }

    fun checkLinesForSafety(input: List<List<Int>>): List<Boolean> {
        return input.map { isLineSafe(it) }.toList();
    }
    fun checkLinesForSafetyWithChecks(input: List<List<Int>>): List<Boolean> {
        //Brute force cause im tired
        return input.map { bruteForceLinesafety(it) }.toList();

    }

    fun bruteForceLinesafety(line: List<Int>): Boolean {
        if (isLineSafe(line)) return true;
        for (i in 0 .. line.size){
            var l : MutableList<Int> = arrayListOf()
            for ((j,e) in line.withIndex()){
                if (j!=i){
                    l.add(e)
                }
            }
            if (isLineSafe(l)) return true;
        }
        return false
    }


    fun isLineSafe(
        line: List<Int>,
    ): Boolean {
        var former = line.first();
        val incr = line[0] < line[1]
        for (i in 1..line.size - 1) {
            val act = line[i]
            val incrAct = act > former
            if (incrAct != incr) return false

            if ((incr && !(act == former + 1 || act == former + 2 ||  act == former + 3)) ||
                (!incr && !(act == former - 1 || act == former - 2 ||  act == former - 3))) {
                return false;
            }
            former = line[i]
        }
        return true;
    }

    fun countSafe(saeftyChecks: List<Boolean>): Int {
        return saeftyChecks.map { if (it == true)  1 else 0 }.sum()
    }



    fun part1(): Int {
        val input = readFile();
        val saeftyChecks = checkLinesForSafety(input ?: listOf() )
        return countSafe(saeftyChecks)
    }

    fun part2(): Int {
        val input = readFile();
        val saeftyChecks = checkLinesForSafetyWithChecks(input ?: listOf() )
        return countSafe(saeftyChecks)
    }

}
package org.example


import java.io.File
import kotlin.math.abs


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    println("Day1 Part1 : ${ Day1("src/main/resources/1_1").part1() }")
}

class Day1(val file: String) {

    fun part1(): Int {
        var input= readFile()
        return computeDistances(input.first, input.second)


    }

    fun readFile(): Pair<ArrayList<Int>, ArrayList<Int>> {
        //val lines =  object {}.javaClass.getResourceAsStream(file)?.bufferedReader()?.lines()
        val lines = File(file).bufferedReader().lines()
        val left = arrayListOf<Int>()
        val right = arrayListOf<Int>()

        for (line in lines) {
            val nums = line.split("   ")
            left.add(nums[0].toInt())
            right.add(nums[1].toInt())
        }

        return Pair(left, right)
    }

    fun computeDistances(l: ArrayList<Int>, r: ArrayList<Int>): Int {
        l.sort()
        r.sort()
        return l.zip(r).map { (a, b) -> abs(a - b) }.sum()
    }

}
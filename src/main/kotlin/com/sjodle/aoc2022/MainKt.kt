package com.sjodle.aoc2022

import com.sjodle.aoc2022.puzzles.*

import kotlin.system.exitProcess

class MainKt {
    companion object {
        private val puzzles = listOf(
            Day01(),
            Day02(),
            Day03(),
            Day04(),
            Day05(),
            Day06(),
        )

        @JvmStatic fun main(args: Array<String>) {
            if (args.count() != 2) {
                println("Usage: aoc2022 <day> <part>")
                exitProcess(1)
            }

            val day = args[0].toInt()
            if (!(1..25).contains(day)) {
                println("Day must be between 1 and 25")
                exitProcess(1)
            }
            val puzzle = puzzles[day-1]

            val part = args[1].toInt()

            val output = when(part) {
                1 -> puzzle.part1()
                2 -> puzzle.part2()
                else -> {
                    println("Part must be 1 or 2")
                    exitProcess(1)
                }
            }

            println("################################")
            println("Day $day, Part $part:\t${output}")
            println("################################")
        }
    }
}
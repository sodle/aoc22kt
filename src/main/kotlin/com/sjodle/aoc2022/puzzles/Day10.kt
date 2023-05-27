package com.sjodle.aoc2022.puzzles

import java.util.LinkedList
import java.util.Queue

class Day10: BasePuzzle<Queue<String>, Int, String>() {
    override fun getPuzzleInput(): Queue<String> {
        val fileContent = this::class.java.getResource("/day10.txt")!!.readText()
        return LinkedList(fileContent.lines().filter { it.isNotBlank() })
    }

    override fun part1(input: Queue<String>): Int {
        var x = 1
        var pc = 0

        var midCycle = false
        var adding = 0

        var signalStrengths = arrayOf<Int>()

        while (input.isNotEmpty() || midCycle) {
            pc++

            if ((pc - 20) % 40 == 0) {
                signalStrengths += x * pc
            }

            if (midCycle) {
                x += adding
                adding = 0
                midCycle = false
            } else {
                val command = input.poll()
                if (command.startsWith("addx")) {
                    midCycle = true
                    adding = command.split(" ")[1].toInt()
                }
            }
        }

        return signalStrengths.sum()
    }

    override fun part2(input: Queue<String>): String {
        var display = ""

        var x = 1
        var pc = 0

        var midCycle = false
        var adding = 0

        while (input.isNotEmpty() || midCycle) {
            pc++

            val xPos = (pc - 1) % 40
            display += if ((x-1..x+1).contains(xPos)) {
                "#"
            } else {
                "."
            }

            if (xPos == 39) {
                display += "\n"
            }

            if (midCycle) {
                x += adding
                adding = 0
                midCycle = false
            } else {
                val command = input.poll()
                if (command.startsWith("addx")) {
                    midCycle = true
                    adding = command.split(" ")[1].toInt()
                }
            }
        }

        return "\n" + display.trimEnd()
    }
}
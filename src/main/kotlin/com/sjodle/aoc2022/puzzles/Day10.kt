package com.sjodle.aoc2022.puzzles

import java.util.LinkedList
import java.util.Queue

private fun runProgram(input: Queue<String>, onCycle: (x: Int, pc: Int) -> Unit) {
    var x = 1
    var pc = 0

    var midCycle = false
    var adding = 0

    while (input.isNotEmpty() || midCycle) {
        pc++

        onCycle(x, pc)

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
}

class Day10: BasePuzzle<Queue<String>, Int, String>() {
    override fun getPuzzleInput(): Queue<String> {
        val fileContent = this::class.java.getResource("/day10.txt")!!.readText()
        return LinkedList(fileContent.lines().filter { it.isNotBlank() })
    }

    override fun part1(input: Queue<String>): Int {
        var signalStrengths = arrayOf<Int>()

        runProgram(input) { x, pc ->
            if ((pc - 20) % 40 == 0) {
                signalStrengths += x * pc
            }
        }

        return signalStrengths.sum()
    }

    override fun part2(input: Queue<String>): String {
        var display = ""

        runProgram(input) { x, pc ->
            val xPos = (pc - 1) % 40
            display += if ((x-1..x+1).contains(xPos)) {
                "#"
            } else {
                "."
            }

            if (xPos == 39) {
                display += "\n"
            }
        }

        return "\n" + display.trimEnd()
    }
}
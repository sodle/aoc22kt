package com.sjodle.aoc2022.puzzles

import kotlin.math.abs

class Day09: BasePuzzle<List<Pair<Char, Int>>, Int>() {
    override fun getPuzzleInput(): List<Pair<Char, Int>> {
        val fileContent = this::class.java.getResource("/day09.txt")!!.readText()
        return fileContent.lines().filter {
            it.isNotBlank()
        }.map {
            val split = it.split(" ")
            Pair(split[0].first(), split[1].toInt())
        }
    }

    override fun part1(input: List<Pair<Char, Int>>): Int {
        var headX = 0
        var headY = 0
        var tailX = 0
        var tailY = 0

        return input.flatMap { instruction ->
            val direction = instruction.first
            val distance = instruction.second

            (1..distance).map { _ ->
                when(direction) {
                    'U' -> {
                        headY++
                    }
                    'D' -> {
                        headY--
                    }
                    'L' -> {
                        headX--
                    }
                    'R' -> {
                        headX++
                    }
                }
                val dx = headX - tailX
                val dy = headY - tailY
                if (maxOf(abs(dx), abs(dy)) > 1) {
                    tailX += dx.let {
                        if (it != 0) {
                            it / abs(it)
                        } else {
                            0
                        }
                    }
                    tailY += dy.let {
                        if (it != 0) {
                            it / abs(it)
                        } else {
                            0
                        }
                    }
                }
                Pair(tailX, tailY)
            }
        }.toSet().size
    }
}
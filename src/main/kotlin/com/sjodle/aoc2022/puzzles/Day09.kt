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
        return runMotions(2, input)
    }

    override fun part2(input: List<Pair<Char, Int>>): Int {
        return runMotions(10, input)
    }

    private fun runMotions(ropeLength: Int, input: List<Pair<Char, Int>>): Int {
        val knots = (1..ropeLength).map {
            Pair(0, 0)
        }.toTypedArray()

        return input.flatMap { instruction ->
            val direction = instruction.first
            val distance = instruction.second

            (1..distance).map { _ ->
                when (direction) {
                    'U' -> {
                        knots[0] = Pair(knots[0].first, knots[0].second + 1)
                    }

                    'D' -> {
                        knots[0] = Pair(knots[0].first, knots[0].second - 1)
                    }

                    'L' -> {
                        knots[0] = Pair(knots[0].first - 1, knots[0].second)
                    }

                    'R' -> {
                        knots[0] = Pair(knots[0].first + 1, knots[0].second)
                    }
                }

                (1 until ropeLength).forEach { idx ->
                    val self = knots[idx]
                    val last = knots[idx - 1]

                    val dx = last.first - self.first
                    val dy = last.second - self.second

                    var x = self.first
                    var y = self.second

                    if (maxOf(abs(dx), abs(dy)) > 1) {
                        x += dx.let {
                            if (it != 0) {
                                it / abs(it)
                            } else {
                                0
                            }
                        }
                        y += dy.let {
                            if (it != 0) {
                                it / abs(it)
                            } else {
                                0
                            }
                        }
                    }
                    knots[idx] = Pair(x, y)
                }

                knots.last()
            }
        }.toSet().size
    }
}
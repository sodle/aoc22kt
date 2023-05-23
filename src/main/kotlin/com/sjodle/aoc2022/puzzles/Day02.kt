package com.sjodle.aoc2022.puzzles

class Day02: BasePuzzle<List<Pair<String, String>>, Int>() {
    override fun getPuzzleInput(): List<Pair<String, String>> {
        val fileContent = this::class.java.getResource("/day02.txt")!!.readText()

        return fileContent.lines().filter { it.isNotEmpty() }.map { line ->
            line.split("\\s+".toRegex()).let { match ->
                Pair(match.first(), match.last())
            }
        }
    }

    private fun scoreShape(shape: String): Int {
        return "XYZ".indexOf(shape) + 1
    }

    private fun scoreMatch(elfShape: String, myShape: String): Int {
        return when(elfShape to myShape) {
            "A" to "X" -> 3
            "A" to "Y" -> 6
            "A" to "Z" -> 0
            "B" to "X" -> 0
            "B" to "Y" -> 3
            "B" to "Z" -> 6
            "C" to "X" -> 6
            "C" to "Y" -> 0
            "C" to "Z" -> 3
            else -> error("Invalid match: $elfShape vs. $myShape")
        }
    }

    private fun throwMatch(elfShape: String, expectedOutcome: String): String {
        val expectedScore = "XYZ".indexOf(expectedOutcome) * 3

        return "XYZ".first {
            scoreMatch(elfShape, it.toString()) == expectedScore
        }.toString()
    }

    override fun part1(input: List<Pair<String, String>>): Int {
        return input.sumOf {
            val elfShape = it.first
            val myShape = it.second
            scoreShape(myShape) + scoreMatch(elfShape, myShape)
        }
    }

    override fun part2(input: List<Pair<String, String>>): Int {
        return input.sumOf {
            val elfShape = it.first
            val expectedOutcome = it.second
            val myShape = throwMatch(elfShape, expectedOutcome)
            scoreShape(myShape) + scoreMatch(elfShape, myShape)
        }
    }
}
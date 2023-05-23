package com.sjodle.aoc2022.puzzles

class Day03: BasePuzzle<List<Pair<String, String>>, Int>() {
    private val alphabet = ('a'..'z') + ('A'..'Z')

    override fun getPuzzleInput(): List<Pair<String, String>> {
        val fileContent = this::class.java.getResource("/day03.txt")!!.readText()

        return fileContent.lines().filter { it.isNotEmpty() }.map {
            val len = it.count()
            val halfLen = len / 2
            Pair(it.substring(0, halfLen), it.substring(halfLen))
        }
    }

    override fun part1(input: List<Pair<String, String>>): Int {
        return input.sumOf { sack ->
            val left = sack.first.toSet()
            val right = sack.second.toSet()

            val commonItems = left.intersect(right)

            commonItems.sumOf {
                alphabet.indexOf(it) + 1
            }
        }
    }

    override fun part2(input: List<Pair<String, String>>): Int {
        return input.chunked(3).sumOf { group ->
            val badge = group.map { sack ->
                (sack.first + sack.second).toSet()
            }.reduce { a, b ->
                a.intersect(b)
            }.first()

            alphabet.indexOf(badge) + 1
        }
    }
}
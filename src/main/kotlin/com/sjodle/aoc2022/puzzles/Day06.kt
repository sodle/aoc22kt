package com.sjodle.aoc2022.puzzles

class Day06: BasePuzzle<String, Int, Int>() {
    override fun getPuzzleInput(): String {
        val fileContent = this::class.java.getResource("/day06.txt")!!.readText()
        return fileContent.lines().first { it.isNotBlank() }
    }

    private fun indexOfFirstHeterogram(input: String, ofLength: Int): Int {
        val idxSpan = ofLength - 1
        return input.mapIndexedNotNull { idx, _ ->
            val lastIdx = idx + idxSpan
            if (lastIdx < input.length) {
                input.slice(idx..lastIdx).toSet()
            } else {
                null
            }
        }.indexOfFirst {
            it.size == ofLength
        } + ofLength
    }

    override fun part1(input: String): Int {
        return indexOfFirstHeterogram(input, 4)
    }

    override fun part2(input: String): Int {
        return indexOfFirstHeterogram(input, 14)
    }
}
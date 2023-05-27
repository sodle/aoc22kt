package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay09 {
    @Test
    fun testGetInput() {
        val puzzle = Day09()
        val input = puzzle.getPuzzleInput()

        assertEquals(listOf(
            'R' to 4,
            'U' to 4,
            'L' to 3,
            'D' to 1,
            'R' to 4,
            'D' to 1,
            'L' to 5,
            'R' to 2,
        ), input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day09()
        val output = puzzle.part1()
        assertEquals(13, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day09()
        val output = puzzle.part2()
        assertEquals(1, output)

        assertEquals(36, puzzle.part2(listOf(
            'R' to 5,
            'U' to 8,
            'L' to 8,
            'D' to 3,
            'R' to 17,
            'D' to 10,
            'L' to 25,
            'U' to 20,
        )))
    }
}
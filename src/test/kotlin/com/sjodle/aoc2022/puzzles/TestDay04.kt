package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay04 {
    @Test
    fun testGetInput() {
        val puzzle = Day04()
        val input = puzzle.getPuzzleInput()
        assertEquals(listOf(
            (2..4).toSet() to (6..8).toSet(),
            (2..3).toSet() to (4..5).toSet(),
            (5..7).toSet() to (7..9).toSet(),
            (2..8).toSet() to (3..7).toSet(),
            (6..6).toSet() to (4..6).toSet(),
            (2..6).toSet() to (4..8).toSet(),
        ), input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day04()
        val output = puzzle.part1()
        assertEquals(2, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day04()
        val output = puzzle.part2()
        assertEquals(4, output)
    }
}
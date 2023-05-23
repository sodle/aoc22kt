package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay02 {
    @Test
    fun testGetInput() {
        val puzzle = Day02()
        val input = puzzle.getPuzzleInput()
        assertEquals(listOf(
            "A" to "Y",
            "B" to "X",
            "C" to "Z",
        ), input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day02()
        val output = puzzle.part1()
        assertEquals(15, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day02()
        val output = puzzle.part2()
        assertEquals(12, output)
    }
}
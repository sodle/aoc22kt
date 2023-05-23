package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay01 {
    @Test
    fun testGetInput() {
        val puzzle = Day01()
        val input = puzzle.getPuzzleInput()
        assertEquals(listOf(
            listOf(1000, 2000, 3000),
            listOf(4000),
            listOf(5000, 6000),
            listOf(7000, 8000, 9000),
            listOf(10000),
        ), input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day01()
        val output = puzzle.part1()
        assertEquals(24000, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day01()
        val output = puzzle.part2()
        assertEquals(45000, output)
    }
}
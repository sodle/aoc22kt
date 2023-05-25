package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay05 {
    @Test
    fun testGetInput() {
        val puzzle = Day05()
        val input = puzzle.getPuzzleInput()

        assertEquals(listOf(
            listOf('Z', 'N'),
            listOf('M', 'C', 'D'),
            listOf('P'),
        ), input.stacks.map {
            it.toList()
        })

        assertEquals(listOf(
            Triple(1, 2, 1),
            Triple(3, 1, 3),
            Triple(2, 2, 1),
            Triple(1, 1, 2),
        ), input.instructions)
    }

    @Test
    fun testPart1() {
        val puzzle = Day05()
        val output = puzzle.part1()
        assertEquals("CMZ", output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day05()
        val output = puzzle.part2()
        assertEquals("MCD", output)
    }
}
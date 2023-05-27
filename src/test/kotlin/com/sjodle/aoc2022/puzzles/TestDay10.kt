package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay10 {
    @Test
    fun testGetInput() {
        val puzzle = Day10()
        val input = puzzle.getPuzzleInput()

        assertEquals(146, input.size)
    }

    @Test
    fun testPart1() {
        val puzzle = Day10()
        val output = puzzle.part1()
        assertEquals(13140, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day10()
        val output = puzzle.part2()
        assertEquals(listOf("",
            "##..##..##..##..##..##..##..##..##..##..",
            "###...###...###...###...###...###...###.",
            "####....####....####....####....####....",
            "#####.....#####.....#####.....#####.....",
            "######......######......######......####",
            "#######.......#######.......#######.....",
        ).joinToString("\n"), output)
    }
}
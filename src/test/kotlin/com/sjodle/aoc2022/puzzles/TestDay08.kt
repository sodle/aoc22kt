package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay08 {
    @Test
    fun testGetInput() {
        val puzzle = Day08()
        val input = puzzle.getPuzzleInput()

        assert(input.treeVisible(1, 1))
        assert(input.treeVisible(2, 1))
        assert(!input.treeVisible(3, 1))
        assert(input.treeVisible(1, 2))
        assert(!input.treeVisible(2, 2))
        assert(input.treeVisible(3, 2))
        assert(!input.treeVisible(1, 3))
        assert(input.treeVisible(2, 3))
        assert(!input.treeVisible(3, 3))

        assertEquals(4, input.scenicScore(2, 1))
        assertEquals(8, input.scenicScore(2, 3))
    }

    @Test
    fun testPart1() {
        val puzzle = Day08()
        val output = puzzle.part1()
        assertEquals(21, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day08()
        val output = puzzle.part2()
        assertEquals(8, output)
    }
}
package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay07 {
    @Test
    fun testGetInput() {
        val puzzle = Day07()
        val input = puzzle.getPuzzleInput()

        assertEquals(mapOf(
            "/a" to 0,
            "/a/e" to 0,
            "/a/e/i" to 584,
            "/a/f" to 29116,
            "/a/g" to 2557,
            "/a/h.lst" to 62596,
            "/b.txt" to 14848514,
            "/c.dat" to 8504156,
            "/d" to 0,
            "/d/j" to 4060174,
            "/d/d.log" to 8033020,
            "/d/d.ext" to 5626152,
            "/d/k" to 7214296,
        ), input.files)
    }

    @Test
    fun testPrefixes() {
        val puzzle = Day07()
        val input = puzzle.getPuzzleInput()

        assertEquals(setOf(
            "/",
            "/a/",
            "/a/e/",
            "/d/",
        ), input.prefixes())
    }

    @Test
    fun testSizeOfPrefix() {
        val puzzle = Day07()
        val input = puzzle.getPuzzleInput()

        assertEquals(584, input.sizeOfPrefix("/a/e/"))
        assertEquals(94853, input.sizeOfPrefix("/a/"))
        assertEquals(24933642, input.sizeOfPrefix("/d/"))
        assertEquals(48381165, input.sizeOfPrefix("/"))
    }

    @Test
    fun testPart1() {
        val puzzle = Day07()
        val output = puzzle.part1()
        assertEquals(95437, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day07()
        val output = puzzle.part2()
        assertEquals(24933642, output)
    }
}
package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay06 {
    @Test
    fun testGetInput() {
        val puzzle = Day06()
        val input = puzzle.getPuzzleInput()

        assertEquals("mjqjpqmgbljsphdztnvjfqwrcgsmlb", input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day06()
        val output = puzzle.part1()
        assertEquals(7, output)

        assertEquals(5, puzzle.part1("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(6, puzzle.part1("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(10, puzzle.part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(11, puzzle.part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }

    @Test
    fun testPart2() {
        val puzzle = Day06()
        val output = puzzle.part2()
        assertEquals(19, output)

        assertEquals(23, puzzle.part2("bvwbjplbgvbhsrlpgdmjqwftvncz"))
        assertEquals(23, puzzle.part2("nppdvjthqldpwncqszvftbrmjlhg"))
        assertEquals(29, puzzle.part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg"))
        assertEquals(26, puzzle.part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw"))
    }
}
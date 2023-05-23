package com.sjodle.aoc2022.puzzles

import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

class TestDay03 {
    @Test
    fun testGetInput() {
        val puzzle = Day03()
        val input = puzzle.getPuzzleInput()
        assertEquals(listOf(
            "vJrwpWtwJgWr" to "hcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGL" to "rsFMfFZSrLrFZsSL",
            "PmmdzqPrV" to "vPwwTWBwg",
            "wMqvLMZHhHMvwLH" to "jbvcjnnSBnvTQFn",
            "ttgJtRGJ" to "QctTZtZT",
            "CrZsJsPPZsGz" to "wwsLwLmpwMDw",
        ), input)
    }

    @Test
    fun testPart1() {
        val puzzle = Day03()
        val output = puzzle.part1()
        assertEquals(157, output)
    }

    @Test
    fun testPart2() {
        val puzzle = Day03()
        val output = puzzle.part2()
        assertEquals(70, output)
    }
}
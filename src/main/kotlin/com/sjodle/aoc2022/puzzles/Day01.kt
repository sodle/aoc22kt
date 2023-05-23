package com.sjodle.aoc2022.puzzles

class Day01: BasePuzzle<List<List<Int>>, Int>() {
    override fun getPuzzleInput(): List<List<Int>> {
        val fileContent = this::class.java.getResource("/day01.txt")!!.readText()

        var elves: Array<List<Int>> = arrayOf()
        var currentElf: Array<Int> = arrayOf()

        fileContent.lines().forEach {
            if (it.isEmpty()) {
                if (currentElf.isNotEmpty()) {
                    elves += currentElf.toList()
                }
                currentElf = arrayOf()
            } else {
                currentElf += it.toInt()
            }
        }

        if (currentElf.isNotEmpty()) {
            elves += currentElf.toList()
        }

        return elves.toList()
    }

    override fun part1(input: List<List<Int>>): Int {
        return input.maxOf {
            it.sum()
        }
    }

    override fun part2(input: List<List<Int>>): Int {
        return input.map {
            it.sum()
        }.sortedDescending().slice(0..2).sum()
    }
}
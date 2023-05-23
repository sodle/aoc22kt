package com.sjodle.aoc2022.puzzles

class Day04: BasePuzzle<List<Pair<Set<Int>, Set<Int>>>, Int>() {
    override fun getPuzzleInput(): List<Pair<Set<Int>, Set<Int>>> {
        val fileContent = this::class.java.getResource("/day04.txt")!!.readText()

        return fileContent.lines().filter { it.isNotEmpty() }.map { line ->
            val match = "(\\d+)-(\\d+),(\\d+)-(\\d+)".toRegex().matchEntire(line)!!
            val coords = match.groups.drop(1).map { it!!.value.toInt() }

            (coords[0]..coords[1]).toSet() to (coords[2]..coords[3]).toSet()
        }
    }

    override fun part1(input: List<Pair<Set<Int>, Set<Int>>>): Int {
        return input.count {
            it.first.containsAll(it.second) or it.second.containsAll(it.first)
        }
    }

    override fun part2(input: List<Pair<Set<Int>, Set<Int>>>): Int {
        return input.count {
            it.first.intersect(it.second).isNotEmpty()
        }
    }
}
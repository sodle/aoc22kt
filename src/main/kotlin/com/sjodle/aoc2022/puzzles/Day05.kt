package com.sjodle.aoc2022.puzzles

import java.util.Stack

class Crane(lines: List<String>) {
    private val stackColumns = lines.first {
        it.matches("[\\s\\d]+".toRegex())
    }.mapIndexedNotNull { index, it ->
        if (it.isDigit()) {
            index
        } else {
            null
        }
    }

    val stacks = stackColumns.map {
        Stack<Char>()
    }

    init {
        lines.filter {
            it.contains("[")
        }.reversed().forEach {
            it.forEachIndexed { index, c ->
                if (c.isLetter()) {
                    val stackIdx = stackColumns.indexOf(index)
                    stacks[stackIdx].push(c)
                }
            }
        }
    }

    val instructions = lines.filter {
        it.startsWith("move")
    }.map {
        val split = it.split(" ")
        Triple(split[1].toInt(), split[3].toInt(), split[5].toInt())
    }

    fun run9000() {
        instructions.forEach {
            repeat(it.first) { _ ->
                val fromIdx = it.second - 1
                val toIdx = it.third - 1
                stacks[toIdx].push(stacks[fromIdx].pop())
            }
        }
    }

    fun run9001() {
        instructions.forEach {
            (1..it.first).map { _ ->
                val fromIdx = it.second - 1
                stacks[fromIdx].pop()
            }.reversed().forEach { crate ->
                val toIdx = it.third - 1
                stacks[toIdx].push(crate)
            }
        }
    }

    val tops: String
        get() = stacks.map { it.peek() }.joinToString("")
}

class Day05: BasePuzzle<Crane, String>() {
    override fun getPuzzleInput(): Crane {
        val fileContent = this::class.java.getResource("/day05.txt")!!.readText()
        return Crane(fileContent.lines())
    }

    override fun part1(input: Crane): String {
        input.run9000()
        return input.tops
    }

    override fun part2(input: Crane): String {
        input.run9001()
        return input.tops
    }
}
package com.sjodle.aoc2022.puzzles

open class BasePuzzle<InputType, OutputType> {
    open fun getPuzzleInput(): InputType {
        TODO("Not yet implemented")
    }

    open fun part1(input: InputType): OutputType {
        TODO("Not yet implemented")
    }
    fun part1(): OutputType {
        return part1(getPuzzleInput())
    }

    open fun part2(input: InputType): OutputType {
        TODO("Not yet implemented")
    }
    fun part2(): OutputType {
        return part2(getPuzzleInput())
    }
}
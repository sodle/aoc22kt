package com.sjodle.aoc2022.puzzles

open class BasePuzzle<InputType, OutputTypePart1, OutputTypePart2> {
    open fun getPuzzleInput(): InputType {
        TODO("Not yet implemented")
    }

    open fun part1(input: InputType): OutputTypePart1 {
        TODO("Not yet implemented")
    }
    fun part1(): OutputTypePart1 {
        return part1(getPuzzleInput())
    }

    open fun part2(input: InputType): OutputTypePart2 {
        TODO("Not yet implemented")
    }
    fun part2(): OutputTypePart2 {
        return part2(getPuzzleInput())
    }
}
package com.sjodle.aoc2022.puzzles

class Forest(lines: List<String>) {
    val rows = lines.filter {
        it.isNotBlank()
    }.map {
        it.split("").filter { c ->
            c.isNotEmpty()
        }.map { c ->
            c.toInt()
        }
    }

    val height = rows.size
    val width = rows[0].size

    val columns = (0 until width).map { colIdx ->
        rows.map { it[colIdx] }
    }

    private fun linearScenicScore(index: Int, file: List<Int>): Int {
        val height = file[index]
        val preViz = when(index) {
            0 -> 0
            else -> file.slice(0 until index)
                .reversed().let {
                    var viz = 0
                    it.forEach { tree ->
                        viz++
                        if (tree >= height) {
                            return@let viz
                        }
                    }
                    viz
                }
        }
        val postViz = when(index) {
            file.size - 1 -> 0
            else -> file.slice(index + 1 until file.size).let {
                var viz = 0
                it.forEach { tree ->
                    viz++
                    if (tree >= height) {
                        return@let viz
                    }
                }
                viz
            }
        }
        return preViz * postViz
    }

    fun scenicScore(x: Int, y: Int): Int {
        val row = rows[y]
        val col = columns[x]

        val horizontalScore = linearScenicScore(x, row)
        val verticalScore = linearScenicScore(y, col)

        return horizontalScore * verticalScore
    }

    fun treeVisible(x: Int, y: Int): Boolean {
        val row = rows[y]
        val col = columns[x]

        val visibleHorizontally = linearVisibility(x, row)
        val visibleVertically = linearVisibility(y, col)

        return visibleHorizontally + visibleVertically > 0
    }

    private fun linearVisibility(index: Int, file: List<Int>): Int {
        val height = file[index]
        var viz = 0

        if (index == 0) {
            viz++
        } else {
            file.slice(0 until index).filter {
                it >= height
            }.let {
                if (it.isEmpty()) {
                    viz++
                }
            }
        }

        if (index == file.size - 1) {
            viz++
        } else {
            file.slice(index + 1 until file.size).filter {
                it >= height
            }.let {
                if (it.isEmpty()) {
                    viz++
                }
            }
        }

        return viz
    }
}

class Day08: BasePuzzle<Forest, Int, Int>() {
    override fun getPuzzleInput(): Forest {
        val fileContent = this::class.java.getResource("/day08.txt")!!.readText()
        return Forest(fileContent.lines())
    }

    override fun part1(input: Forest): Int {
        return (0 until input.height).flatMap { y ->
            (0 until input.width).map { x ->
                input.treeVisible(x, y)
            }
        }.filter { it }.size
    }

    override fun part2(input: Forest): Int {
        return (0 until input.height).flatMap { y ->
            (0 until input.width).map { x ->
                input.scenicScore(x, y)
            }
        }.max()
    }
}
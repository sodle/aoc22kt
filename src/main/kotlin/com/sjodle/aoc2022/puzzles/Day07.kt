package com.sjodle.aoc2022.puzzles

class Filesystem(lines: List<String>) {
    var files = mutableMapOf<String, Int>()
    private var pwd = "/"

    init {
        lines.filter {
            it.isNotEmpty()
        }.forEach {
            if (it.startsWith("$ cd")) {
                val arg = it.split(" ")[2]
                if (arg.startsWith("/")) {
                    pwd = arg
                } else if (arg == "..") {
                    var pwdComponents = pwd.split("/")
                    pwdComponents = pwdComponents.dropLast(2)
                    pwd = pwdComponents.joinToString("/") + "/"
                } else {
                    pwd += ("$arg/")
                }
            } else if (it.startsWith("dir ")) {
                val name = it.split(" ").last()
                files[pwd+name] = 0
            } else if (it.first().isDigit()) {
                val split = it.split(" ")
                val size = split[0].toInt()
                val name = split[1]
                files[pwd+name] = size
            }
        }
    }

    fun prefixes(): Set<String> {
        return files.keys.map {
            it.split("/").dropLast(1).joinToString("/") + "/"
        }.toSet()
    }

    fun sizeOfPrefix(prefix: String): Int {
        return files.filterKeys {
            it.startsWith(prefix)
        }.values.sum()
    }
}

class Day07: BasePuzzle<Filesystem, Int>() {
    override fun getPuzzleInput(): Filesystem {
        val fileContent = this::class.java.getResource("/day07.txt")!!.readText()

        return Filesystem(fileContent.lines())
    }

    override fun part1(input: Filesystem): Int {
        return input.prefixes().map {
            input.sizeOfPrefix(it)
        }.filter {
            it <= 100000
        }.sum()
    }

    override fun part2(input: Filesystem): Int {
        val diskTotal = 70000000
        val diskNeeded = 30000000
        val diskUsed = input.sizeOfPrefix("/")
        val diskFree = diskTotal - diskUsed

        val needToFree = diskNeeded - diskFree

        return input.prefixes().map {
            input.sizeOfPrefix(it)
        }.filter {
            it >= needToFree
        }.min()
    }
}
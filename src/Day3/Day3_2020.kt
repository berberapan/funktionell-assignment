package Day3

import dataText

val data = dataText("src/data/day3.txt")

fun encounteredTrees(input: List<String>): Int {
    var counter = 0
    var position = 3

    for (mapLine in 1..<input.size) {
        if (input[mapLine][position] == '#') {
            counter++
        }
        if (position + 3 > input[mapLine].length-1 ) {
            position = (position + 3) - (input[mapLine].length)
        }else {
            position += 3
        }
    }
    return counter
}

fun diffRoutesMulti(input: List<String>): Long {
    val routesRight = listOf(1, 3, 5, 7, 1)
    val routesDown = listOf(1, 1, 1, 1, 2)

    fun innerTreeCheck(right: Int, down: Int): Int {
        var position = right
        var counter = 0
        for (mapLine in down..<input.size step down) {
            if (input[mapLine][position] == '#') {
                counter++
            }
            if (position + right > input[mapLine].length-1 ) {
                position = (position + right) - (input[mapLine].length)
            }else {
                position += right
            }
        }
        return counter
    }
    var multiValue = 1L
    for (num in routesDown.indices) {
        multiValue *= innerTreeCheck(routesRight[num], routesDown[num])
    }
    return multiValue
}

fun main() {
    println("Solution to part 1: ${encounteredTrees(data)}")
    println("Solution to part 2: ${diffRoutesMulti(data)}")
}

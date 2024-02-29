package Day5

import dataText

val data = dataText("src/data/day5.txt")
fun mid(lo: Int, hi: Int) = lo + (hi - lo) / 2

fun findID(input: String): Int {
    fun innerFind(value: String, lo: Int, hi: Int): Int {
        var high = hi
        var low = lo
        for (divider in value) {
            if (divider.equals('F') || divider.equals('L')) high = mid(low, high)
            else low = mid(low, high) + 1
        }
        return if (value[value.length-1].equals('F') || value[value.length-1].equals('L')) low else high
    }
    val row = innerFind(input.take(7), 0, 127)
    val column = innerFind(input.takeLast(3), 0, 7)
    return (row * 8) + column
}

// Part one
fun findHighestID(input: List<String>): Int {
    var maxValue = Int.MIN_VALUE
    input.forEach {entry -> if(maxValue < findID(entry)) maxValue = findID(entry) }
    return maxValue
}

fun findLowestID(input: List<String>): Int {
    var minValue = Int.MAX_VALUE
    input.forEach {entry -> if(minValue > findID(entry)) minValue = findID(entry) }
    return minValue
}
//Part two
fun findSeat(input: List<String>): Int {
    val occupiedID = mutableListOf<Int>()
    input.forEach { entry -> occupiedID.add(findID(entry)) }
    for (num in findLowestID(input)..findHighestID(input)) {
        if (num !in occupiedID) return num
    }
    return -1
}

fun main() {
    println("Solution to part 1: ${findHighestID(data)}")
    println("Solution to part 2: ${findSeat(data)}")
}
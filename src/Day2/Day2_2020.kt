package Day2

import Day3.counter
import dataText

val data = dataText("src/data/day2.txt")

// Part 1
fun amountCorrectPasswords1(input: List<String>): Int {
    var counter = 0
    for (data in input) {
        val password = data.split(":")[1].trim()
        val character = data.split(":")[0].split(" ")[1]
        val conditions = data.split(":")[0].split(" ")[0].split("-")
        if (password.count { character.contains(it) } >= conditions[0].toInt() &&
            password.count { character.contains(it) } <= conditions[1].toInt() )
            counter++
    }
    return counter
}

// Part 2
fun amountCorrectPasswords2(input: List<String>): Int {
    var counter = 0
    for (data in input){
        val password = data.split(":")[1].trim()
        val character = data.split(":")[0].split(" ")[1]
        val conditions = data.split(":")[0].split(" ")[0].split("-")
        if ((password[conditions[0].toInt()-1].toString() == character) != (password[conditions[1].toInt()-1].toString() == character)) {
            counter++
        }
    }
    return counter
}

// Inspiration https://old.reddit.com/r/adventofcode/comments/k52psu/2020_day_02_solutions/geccwsn/
fun amountValid(input: List<String>): Int {
    var counter = 0
    input.forEach { it ->
        val password = it.split(":")[1].trim()
        val character = it.split(":")[0].split(" ")[1]
        val lo = it.substringBefore("-").toInt()
        val hi = it.substringAfter("-").substringBefore(" ").toInt()
        if (password.count { character.contains(it)} in lo..hi) counter++
    }
    return counter
}

fun amountValid2(input: List<String>): Int {
    var counter = 0
    input.forEach {
        val password = it.split(":")[1].trim()
        val character = it.split(":")[0].split(" ")[1]
        val lo = it.substringBefore("-").toInt()
        val hi = it.substringAfter("-").substringBefore(" ").toInt()
        if ((character == password[lo-1].toString()) xor (character == password[hi-1].toString())) counter++
    }
    return counter
}


fun main() {
    println("Solution part one: ${amountCorrectPasswords1(data)}")
    println("Solution part two: ${amountCorrectPasswords2(data)}")

    println(amountValid(data))
    println(amountValid2(data))

}
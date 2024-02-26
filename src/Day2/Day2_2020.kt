package Day2

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

// Inspiration https://github.com/JanGroot/aoc202xkotlin/blob/main/src/main/kotlin/twentytwenty/Day2.kt

fun main() {
    println("Solution part one: ${amountCorrectPasswords1(data)}")
    println("Solution part two: ${amountCorrectPasswords2(data)}")
}
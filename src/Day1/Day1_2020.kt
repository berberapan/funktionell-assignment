package Day1

import dataInts

val values = dataInts("src/data/day1.txt")

//Part 1
fun checkSum1(input: List<Int>): Int {
    for (firstNum in  input.indices) {
        for (secondNum in firstNum + 1 ..< input.size) {
            if (input[firstNum] + input[secondNum] == 2020)
                return input[firstNum] * input[secondNum]
        }
    }
    return -1
}

//Part 2
fun checkSum2(input: List<Int>): Int {
    for (firstNum in  input.indices) {
        for (secondNum in firstNum + 1 ..< input.size) {
            for (thirdNum in secondNum + 1 ..< input.size) {
                if (input[firstNum] + input[secondNum] + input[thirdNum] == 2020)
                    return input[firstNum] * input[secondNum] * input[thirdNum]
            }
        }
    }
    return -1
}

// Inspiration https://old.reddit.com/r/adventofcode/comments/k4e4lm/2020_day_1_solutions/ge9d0ld/

fun checksum3(input: List<Int>) = input.flatMap { num1 -> input.map { num2 -> num1 to num2}}
    .filter{ (num1, num2) -> num1 + num2 == 2020 }.map { (num1,num2) -> num1 * num2 }.first()

fun checksum4(input: List<Int>) = input.flatMap { num1 -> input.flatMap { num2 -> input.map { num3 -> Triple(num1, num2, num3) } } }
    .filter { (num1, num2, num3) -> num1 + num2 + num3 == 2020 }.map { (num1, num2, num3) -> num1 * num2 * num3 }.first()
fun main() {
    println(checkSum1(values))
    println(checkSum2(values))

    println(checksum3(values))
    println(checksum4(values))
}



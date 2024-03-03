package Day6

// original
import dataFull

val data = dataFull("src/data/day6.txt").split("\r\n\r\n")
fun sumYes(input: List<String>) = input.sumOf { group -> group.filter { it in 'a'..'z' }.toSet().size }

fun sumEveryoneYes(input: List<String>) =
    input.map { group -> group.split("\r") }
        .sumOf { list -> list.map { it.trim().toSortedSet() }
            .reduce { acc, set -> acc.intersect(set).toSortedSet() }.size }

//Lösning inspirerad av https://old.reddit.com/r/adventofcode/comments/k7ndux/2020_day_06_solutions/gevbopu/

fun sumEveryoneYes2(input: List<String>) =
    input.sumOf { it.lines().map{ it.trim().toSet() }.reduce { acc, set -> acc.intersect(set)}.size }

fun main(){
    println("Solution part 1: ${sumYes(data)}")
    println("Solution part 2: ${sumEveryoneYes(data)}")
    println(sumEveryoneYes2(data))
}
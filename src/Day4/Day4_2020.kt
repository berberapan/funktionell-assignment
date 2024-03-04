package Day4

import dataText
import dataFull

val data = dataText("src/data/day4.txt")

// original
fun passportCheck(input: List<String>): Int {
    var count = 0
    var passportInfo = ""
    val passports = mutableListOf<String>()
    val requiredInfo = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    input.indices.forEach { row ->
        if (input[row].isEmpty()) {passports.add(passportInfo.trim())
            passportInfo = ""}
        else if (row == input.size-1) { passportInfo += input[row]
            passports.add(passportInfo.trim())}
        else passportInfo += input[row] + " "}

    passports.forEach { passport ->
        if (passport.contains(requiredInfo[0]) && passport.contains(requiredInfo[1]) && passport.contains(requiredInfo[2])
            && passport.contains(requiredInfo[3]) && passport.contains(requiredInfo[4])
            && passport.contains(requiredInfo[5]) && passport.contains(requiredInfo[6])) count++
    }
    return count
}

fun passportCheck2(input: List<String>): Int {
    var count = 0
    var passportInfo = ""
    val passports = mutableListOf<String>()
    val requiredInfo = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    input.indices.forEach { row ->
        if (input[row].isEmpty()) {passports.add(passportInfo.trim())
            passportInfo = ""}
        else if (row == input.size-1) { passportInfo += input[row]
            passports.add(passportInfo.trim())}
        else passportInfo += input[row] + " "}

    fun innerCheck(passport: String): Boolean {
        val byrPattern = Regex("byr:(\\d+)")
        val byrResult = byrPattern.find(passport)
        val byr = byrResult!!.groupValues[1].toInt()

        val iyrPattern = Regex("iyr:(\\d+)")
        val iyrResult = iyrPattern.find(passport)
        val iyr = iyrResult!!.groupValues[1].toInt()

        val eyrPattern = Regex("eyr:(\\d+)")
        val eyrResult = eyrPattern.find(passport)
        val eyr = eyrResult!!.groupValues[1].toInt()

        val hgtPattern = Regex("hgt:(\\w+)")
        val hgtResult = hgtPattern.find(passport)
        val hgt = hgtResult!!.groupValues[1]

        val hclPattern = Regex("hcl:(\\S+)")
        val hclResult = hclPattern.find(passport)
        val hcl = hclResult!!.groupValues[1]

        val eclPattern = Regex("ecl:(\\S+)")
        val eclResult = eclPattern.find(passport)
        val ecl = eclResult!!.groupValues[1]

        val pidPattern = Regex("pid:(\\S+)")
        val pidResult = pidPattern.find(passport)
        val pid = pidResult!!.groupValues[1]

        if (byr !in 1920..2002) return false
        if (iyr !in 2010..2020) return false
        if (eyr !in 2020..2030) return false
        if (hgt.contains("in") && hgt.substring(0, hgt.indexOf("in")).toInt() !in 59..76) return false
        if (hgt.contains("cm") && hgt.substring(0, hgt.indexOf("cm")).toInt() !in 150..193) return false
        if (!hgt.contains("cm") && !hgt.contains("in")) return false
        if (hcl.length != 7 || hcl[0] != '#') return false
        hcl.substring(1).forEach { c -> if (c !in 'a'..'f' && c !in '0'..'9') return false }
        if (ecl !in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) return false
        if (pid.length != 9) return false
        pid.forEach { num -> if (num !in '0'..'9') return false }

        return true
    }
    passports.forEach { passport ->
        if (passport.contains(requiredInfo[0]) && passport.contains(requiredInfo[1]) && passport.contains(requiredInfo[2])
            && passport.contains(requiredInfo[3]) && passport.contains(requiredInfo[4])
            && passport.contains(requiredInfo[5]) && passport.contains(requiredInfo[6])) if (innerCheck(passport)) count++
    }
    return count
}

//Lösning inspirerad av https://old.reddit.com/r/adventofcode/comments/k6e8sw/2020_day_04_solutions/gen3xx1/
val data2 = dataFull("src/data/day4.txt").split("\r\n\r\n")
val requiredInfo = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")
fun checkPP() = data2.count { pp -> requiredInfo.all { pp.contains(it) } }

fun passportCheck4(input: List<String>): Int {
    var count = 0
    val requiredInfo = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    fun innerCheck(passport: String): Boolean {
        val patterns = mapOf(
            "byr" to Regex("byr:(\\d+)"),
            "iyr" to Regex("iyr:(\\d+)"),
            "eyr" to Regex("eyr:(\\d+)"),
            "hgt" to Regex("hgt:(\\w+)"),
            "hcl" to Regex("hcl:(\\S+)"),
            "ecl" to Regex("ecl:(\\S+)"),
            "pid" to Regex("pid:(\\S+)")
        )

        val data = patterns.mapValues { it.value.find(passport)?.groupValues?.get(1) ?: return false }

        if (data["byr"]?.toInt() !in 1920..2002) return false
        if (data["iyr"]?.toInt() !in 2010..2020) return false
        if (data["eyr"]?.toInt() !in 2020..2030) return false

        val hgt = data["hgt"]!!
        if (hgt.contains("in") && hgt.substringBefore("in").toInt() !in 59..76) return false
        if (hgt.contains("cm") && hgt.substringBefore("cm").toInt() !in 150..193) return false
        if (!hgt.contains("cm") && !hgt.contains("in")) return false

        val hcl = data["hcl"]!!
        if (hcl.length != 7 || hcl[0] != '#') return false
        if (!hcl.drop(1).all { it in 'a'..'f' || it in '0'..'9' }) return false

        if (data["ecl"] !in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")) return false

        val pid = data["pid"]!!
        if (pid.length != 9 || !pid.all { it in '0'..'9' }) return false

        return true
    }

    input.forEach { passport ->
        if (requiredInfo.all { passport.contains(it) } && innerCheck(passport)) count++
    }

    return count
}

fun main() {
    println("Solution part 1: ${passportCheck(data)}")
    println("Solution part 2: ${passportCheck2(data)}")

    println(checkPP())
    println(passportCheck4(data2))

}
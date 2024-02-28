package Day4

import dataText

val data = dataText("src/data/day4.txt")

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

fun main() {
    println("Solution part 1: ${passportCheck(data)}")
    println("Solution part 2: ${passportCheck2(data)}")
}
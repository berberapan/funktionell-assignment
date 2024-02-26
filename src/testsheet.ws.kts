val a = "1-3 a: abcde"

val ab = a.trim().split(":")
println(ab[1])
println(ab)
val pchar = ab[0].split(" ")[1]
println(pchar)
val condition = ab[0].split(" ")[0].split("-")
println(condition)

val test = a.trim().split((":"))[0].split(" ")[0].split("-")
println(test)

val adf = mapOf("a" to "[1, 3]")
println(adf["a"])

a.count { pchar.contains(it) }

val pass = "ccccccccc"
val char = 'c'
val cond = listOf(2,9)

val sats = if (pass[cond[0]-1] == char) "true" else "false"
println(sats)
val sats2 = if (pass[cond[1]-1] == char) "true" else "false"
println(sats2)

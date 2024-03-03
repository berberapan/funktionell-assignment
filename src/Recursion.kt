val hierarchyMap = mapOf(
    "Tomten" to listOf("Glader", "Butter"),
    "Glader" to listOf("Tröger", "Trötter", "Blyger"),
    "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
    "Trötter" to listOf("Skumtomten"),
    "Räven" to listOf("Gråsuggan", "Myran"),
    "Skumtomten" to listOf("Dammråttan"),
    "Myran" to listOf("Bladlusen")
)

// DFS - Preorder

fun getUnderlings(userInput: String): List<String> {
    val underlings = mutableListOf<String>()
    fun innerGetUnderling(worker: String) {
        if (worker != userInput) underlings.add(worker)
        hierarchyMap[worker]?.forEach { underling -> innerGetUnderling(underling) }
    }
    innerGetUnderling(userInput)
    return underlings
}

fun main() {
    print("Vem vill du söka på?: ")
    val input = readln()
    println()
    val underlings = getUnderlings(input)
    underlings.forEach() { println(it)}
}

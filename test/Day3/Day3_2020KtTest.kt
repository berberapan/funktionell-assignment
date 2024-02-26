package Day3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day3_2020KtTest {

    val testData: List<String> = listOf("..##.......",
                                        "#...#...#..",
                                        ".#....#..#.",
                                        "..#.#...#.#",
                                        ".#...##..#.",
                                        "..#.##.....",
                                        ".#.#.#....#",
                                        ".#........#",
                                        "#.##...#...",
                                        "#...##....#",
                                        ".#..#...#.#")


    @Test
    fun encounteredTreesTest() {
        assertEquals(7, encounteredTrees(testData))
    }

    @Test
    fun multiTest() {
        assertEquals(336, diffRoutesMulti(testData))
    }
}
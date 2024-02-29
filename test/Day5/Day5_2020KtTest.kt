package Day5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day5_2020KtTest {

    @Test
    fun midTest() {
        assertEquals(63, mid(0, 127))
        assertEquals(44, mid(44, 45))
    }

    @Test
    fun findIDTest() {
        assertEquals(567, findID("BFFFBBFRRR"))
        assertEquals(119, findID("FFFBBBFRRR"))
        assertEquals(820, findID("BBFFBBFRLL"))

    }
    @Test
    fun findHighestTest() {
        val testValues = listOf("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL")
        assertEquals(820, findHighestID(testValues))
    }
}
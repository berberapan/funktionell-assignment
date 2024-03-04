package Day6

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day6_2020KtTest {

    val testValues = listOf("abc", "a\r\nb\r\nc", "ab\r\nac", "a\r\na\r\na\r\na", "b")

    @Test
    fun sumYesTest() {
        assertEquals(11, sumYes(testValues))
    }

    @Test
    fun sumEveryoneYesTest() {
        assertEquals(6, sumEveryoneYes(testValues))
        assertEquals(6, sumEveryoneYes2(testValues))
    }
}
package Day1

import Day1.checkSum1
import Day1.checkSum2
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day1_2020KtTest {

    private val testValues = listOf(1721, 979, 366, 299, 675, 1456)

    @Test
    fun checkSum1Test() {
        assertEquals(514579, checkSum1(testValues))
    }

    @Test
    fun checkSum2Test() {
        assertEquals(241861950, checkSum2(testValues))
    }
}
package Day2

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Day2_2020KtTest {

    val testData: List<String> = listOf("1-3 a: abcde",
                                        "1-3 b: cdefg",
                                        "2-9 c: ccccccccc")

    @Test
    fun amountCorrectPasswords1() {
        assertEquals(2, amountCorrectPasswords1(testData))
        assertEquals(2, amountValid(testData))
    }

    @Test
    fun amountCorrectPasswords2() {
        assertEquals(1, amountCorrectPasswords2(testData))
        assertEquals(1, amountValid2(testData))
    }
}
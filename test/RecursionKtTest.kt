import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.util.Collections

class RecursionKtTest {

    var uTomten: List<String> = mutableListOf(
        "Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten", "Glader",
        "Butter", "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran", "Bladlusen"
    )
    var uGlader: List<String> = mutableListOf("Tröger", "Trötter", "Blyger", "Dammråttan", "Skumtomten")
    var uButter: List<String> = mutableListOf(
        "Rådjuret", "Nyckelpigan", "Haren", "Räven", "Gråsuggan", "Myran",
        "Bladlusen"
    )
    var uTrötter: List<String> = mutableListOf("Dammråttan", "Skumtomten")
    var uSkumtomten: List<String> = mutableListOf("Dammråttan")
    var uRäven: List<String> = mutableListOf("Gråsuggan", "Myran", "Bladlusen")
    var uMyran: List<String> = mutableListOf("Bladlusen")

    @Test
    fun getUnderlingBladlusenTest() {
        val underlings = getUnderlings("Bladlusen")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingTrögerTest() {
        val underlings = getUnderlings("Tröger")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingBlygerTest() {
        val underlings = getUnderlings("Blyger")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingDammråttanTest() {
        val underlings = getUnderlings("Dammråttan")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingGråsugganTest() {
        val underlings = getUnderlings("Gråsuggan")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingHarenTest() {
        val underlings = getUnderlings("Haren")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingNyckelpiganTest() {
        val underlings = getUnderlings("Nyckelpigan")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingRådjuretTest() {
        val underlings = getUnderlings("Rådjuret")
        assert(underlings.isEmpty())
    }

    @Test
    fun getUnderlingMyranTest() {
        val underlings = getUnderlings("Myran")
        assert(underlings.size == uMyran.size)
        assert(underlings == uMyran)
    }

    @Test
    fun getUnderlingRävenTest() {
        val underlings = getUnderlings("Räven")
        assert(underlings.size == uRäven.size)
        Collections.sort(uRäven)
        Collections.sort(underlings)
        assertEquals(uRäven, underlings)
    }

    @Test
    fun getUnderlingSkumtomtenTest() {
        val underlings = getUnderlings("Skumtomten")
        assert(underlings.size == uSkumtomten.size)
        Collections.sort(uSkumtomten)
        Collections.sort(underlings)
        assertEquals(uSkumtomten, underlings)
    }

    @Test
    fun getUnderlingTrötterTest() {
        val underlings = getUnderlings("Trötter")
        assert(underlings.size == uTrötter.size)
        Collections.sort(uTrötter)
        Collections.sort(underlings)
        assertEquals(uTrötter, underlings)
    }

    @Test
    fun getUnderlingButterTest() {
        val underlings = getUnderlings("Butter")
        assert(underlings.size == uButter.size)
        Collections.sort(uButter)
        Collections.sort(underlings)
        assertEquals(uButter, underlings)
    }

    @Test
    fun getUnderlingGladerTest() {
        val underlings = getUnderlings("Glader")
        assert(underlings.size == uGlader.size)
        Collections.sort(uGlader)
        Collections.sort(underlings)
        assertEquals(uGlader, underlings)
    }

    @Test
    fun getUnderlingTomtenTest() {
        val underlings = getUnderlings("Tomten")
        assert(underlings.size == uTomten.size)
        Collections.sort(uTomten)
        Collections.sort(underlings)
        assertEquals(uTomten, underlings)
    }
}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun `find2020Sum empty list returns empty list`() {
        assertEquals(find2020Sum(listOf()), listOf<Int>())
    }

    @Test
    fun `find2020Sum with list 1010 1010 returns 1010 1010`() {
        assertEquals(find2020Sum(listOf(1010, 1010)), listOf(1010, 1010))
    }
}
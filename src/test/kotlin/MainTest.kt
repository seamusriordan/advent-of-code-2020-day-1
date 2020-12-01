import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun `find2020Sum empty list returns empty list`() {
        assertEquals(find2020Sum(listOf()), listOf<Int>())
    }
}
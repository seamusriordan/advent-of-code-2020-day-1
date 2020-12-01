import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MainTest {
    @Test
    fun `find2020Sum with list 1010 1010 returns 1010 1010`() {
        assertEquals(find2020Sum(listOf(1010, 1010)), Pair(1010, 1010))
    }

    @Test
    fun `find2020Sum with list 1009 1011 returns 1009 1011`() {
        assertEquals(find2020Sum(listOf(1009, 1011)), Pair(1009, 1011))
    }

    @Test
    fun `find2020Sum with list 0 1009 1011 returns 1009 1011`() {
        assertEquals(find2020Sum(listOf(0, 1009, 1011)), Pair(1009, 1011))
    }

    @Test
    fun `find2020Sum with list 1009 1011 0 returns 1009 1011`() {
        assertEquals(find2020Sum(listOf(1009, 1011, 0)), Pair(1009, 1011))
    }

    @Test
    fun `find2020Sum with list 1009 0 1011 returns 1009 1011`() {
        assertEquals(find2020Sum(listOf(1009, 0, 1011)), Pair(1009, 1011))
    }

    @Test
    fun `find2020Sum with list 1010 1009 1011 returns 1009 1011`() {
        assertEquals(find2020Sum(listOf(1010, 1009, 1011)), Pair(1009, 1011))
    }

    @Test
    fun `example criteria`() {
        val exampleList = listOf(1721, 979, 366, 299, 675, 1456)

        assertEquals(find2020Sum(exampleList), Pair(1721, 299))

    }

    @Test
    fun `find2020Triple with list 505, 505, 1010 returns 505, 505, 1010`() {
        assertEquals(find2020Triple(listOf(505, 505, 1010)), Triple(505, 505, 1010))
    }

    @Test
    fun `find2020Triple with list 0, 505, 505, 1010 returns 505, 505, 1010`() {
        assertEquals(find2020Triple(listOf(0, 505, 505, 1010)), Triple(505, 505, 1010))
    }

//    @Test
//    fun `find2020Triple with list 505, 0, 505, 1010 returns 505, 505, 1010`() {
//        assertEquals(find2020Triple(listOf(505, 0, 505, 1010)), Triple(505, 505, 1010))
//    }
}
import org.example.Day2
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class Day2Test{


    @Test
    fun testP1(){
        val file = "src/test/resources/day2_test"
        assert(File(file).isFile)
        val d = Day2(file)
        val input = d.readFile();
        assertEquals(6, input?.size)
        assertEquals(5, input?.first()?.size)
        val saeftyChecks = d.checkLinesForSafety(input ?: listOf() )
        assertTrue(saeftyChecks[0])
        assertFalse(saeftyChecks[1])
        print(saeftyChecks)
        assertEquals(2, d.countSafe(saeftyChecks))
        assertEquals(4, d.countSafe(d.checkLinesForSafetyWithChecks(input ?: listOf())))
    }
}
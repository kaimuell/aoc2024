import org.example.Day3
import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test{

    @Test
    fun testP1(){
        val d = Day3("src/test/resources/day3_test")
        val input  = d.readFile();
        val multipliedNumbers = d.searchAndMultiply(input)
        assertEquals(161, multipliedNumbers)
    }
}
import org.example.Day1
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals


class Day1Test {
    @Test
    fun `teste Day1 Teil 1`(): Unit {
        val file = "src/test/resources/day1_test"
        assert(File(file).isFile)
        val d = Day1(file)
        val (l, r) = d.readFile()
        assertEquals(l.size, r.size)
        print(l)
        assertEquals(16, l.sum())
        assertEquals(11, d.computeDistances(l, r))

    }

}
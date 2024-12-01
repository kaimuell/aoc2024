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
        assertEquals(16, l.sum())
        assertEquals(11, d.computeDistances(l, r))

    }

    @Test
    fun `teste Day1 Teil 2`(): Unit {
        val file = "src/test/resources/day1_test"
        assert(File(file).isFile)
        val d = Day1(file)
        val (l, r) = d.readFile()
        assertEquals(l.size, r.size)
        val scores : Map<Int, Int> = d.computeSimilarityScores(r)
        assertEquals(3, scores.get(3))
        assertEquals(31, d.sumSimilarityScores(l, scores))
    }

}
package knapsack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class KnapsackFullCalcTest {

    private val target = KnapsackFullCalc

    @Test
    fun test() {
        val expected = 14 // (4,3) (1,2) (2,3) (3,6) を選ぶのが最大効率
        val actual = target.calc(TestHelper.weights1, TestHelper.values1, TestHelper.weightMax1)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test1() {
        val expected = 20
        val actual = target.calc(TestHelper.weights2, TestHelper.values2, TestHelper.weightMax2)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val expected = 94 // (3,6), (1,3), (5,85)
        val actual = target.calc(TestHelper.weights3, TestHelper.values3, TestHelper.weightMax3)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val expected = 13
        val actual = target.calc(TestHelper.weights4, TestHelper.values4, TestHelper.weightMax4)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test4() {
        val expected = 12180
        val actual = target.calc(TestHelper.weights5, TestHelper.values5, TestHelper.weightMax5)
        Assertions.assertEquals(expected, actual)
    }
}

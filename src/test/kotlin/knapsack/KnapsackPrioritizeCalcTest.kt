package knapsack

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 価値優先探索の場合のテスト
 * @property target KnapsackPrioritizeCalc
 */
internal class KnapsackPrioritizeCalcTest {

    private val target = KnapsackPrioritizeCalc

    @Test
    fun test1() {
        val expected = 14 // (4,3) (1,2) (2,3) (3,6) を選ぶのが最大効率
        val actual = target.calc(TestHelper.weights1, TestHelper.values1, TestHelper.weightMax1)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test2() {
        val expected = 19 // 全探索の場合には -> 20
        val actual = target.calc(TestHelper.weights2, TestHelper.values2, TestHelper.weightMax2)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test3() {
        val expected = 94
        val actual = target.calc(TestHelper.weights3, TestHelper.values3, TestHelper.weightMax3)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test4() {
        val expected = 13
        val actual = target.calc(TestHelper.weights4, TestHelper.values4, TestHelper.weightMax4)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test5() {
        val expected = 12129 // 全探索の場合には -> 12180
        val actual = target.calc(TestHelper.weights5, TestHelper.values5, TestHelper.weightMax5)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test6() {
        val expected = 15201 // 全探索の場合には -> 15213
        val actual = target.calc(TestHelper.weights6, TestHelper.values6, TestHelper.weightMax6)
        Assertions.assertEquals(expected, actual)
    }

    @Test
    fun test7() {
        val expected = 10000
        val actual = target.calc(TestHelper.weights7, TestHelper.values7, TestHelper.weightMax7)
        Assertions.assertEquals(expected, actual)
    }
}

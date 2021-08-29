import knapsack.KnapsackFullCalc
import knapsack.KnapsackPrioritizeCalc
import knapsack.TestHelper
import knapsack.TestHelper.weightMax1
import knapsack.TestHelper.weightMax5

fun main() {
    println("Hello Knapsack Problem!")

    var actual = KnapsackFullCalc.calc(TestHelper.weights1, TestHelper.values1, weightMax1)
    println("Full Exploration: $actual")

    actual = KnapsackPrioritizeCalc.calc(TestHelper.weights5, TestHelper.values5, weightMax5)
    println("Prioritize HighValue: $actual")
}

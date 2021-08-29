import knapsack.KnapsackCalc

fun main() {
    println("Hello Knapsack Problem!")

    val weights = listOf(3, 4, 1, 2, 3)
    val values = listOf(2, 3, 2, 3, 6)
    val weightMax = 10

    var actual = KnapsackCalc.fullExploration(weights, values, weightMax)
    println("Full Exploration: $actual")

    actual = KnapsackCalc.prioritizeHighValue(weights, values, weightMax)
    println("Prioritize HighValue: $actual")
}

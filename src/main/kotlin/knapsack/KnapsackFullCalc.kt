package knapsack

import max

// ナップサック問題
object KnapsackFullCalc {

    /**
     * 全探索、２次元配列を使うパターン
     */
    fun calc(weights: List<Int>, values: List<Int>, weightMax: Int): Int {
        val n = weights.size
        val dp = Array(n + 1) { IntArray(weightMax + 1) } // ２次元配列

        weights.forEachIndexed { i, currentWeight ->
            val currentValue = values[i]
            // 全探索
            for (w in 0..weightMax) {
                val value = dp[i][w]
                dp[i + 1][w] = if (w < weights[i]) {
                    // 品物i の重さが w を超えている場合は、
                    // 品物i は追加できないから、価値の合計は品物の添字の上限が1つ前までのものの価値の最大値になる
                    value
                } else {
                    // 品物i の重さが w を超えていない場合には、
                    // 品物i を追加しない場合と追加をする場合の価値の最大値の両方のうちで、小さくない方の値にする
                    val nextIndex = w - currentWeight
                    max(value, dp[i][nextIndex] + currentValue)
                }
            }
        }
        return dp[n][weightMax]
    }
}

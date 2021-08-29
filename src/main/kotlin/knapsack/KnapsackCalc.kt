package knapsack

import max
import toIntNullable

// ナップサック問題
object KnapsackCalc {

    /**
     * 全探索、２次元配列を使うパターン
     */
    fun fullExploration(weights: List<Int>, values: List<Int>, weightMax: Int): Int {
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

    /**
     * 価値が大きいもの優先： ある重さにおける最大の価値を優先
     * 順番に埋めていく
     * メモリを省エネするためにHashを使っています
     */
    fun prioritizeHighValue(weights: List<Int>, values: List<Int>, weightMax: Int): Int {
        val dp = mutableMapOf<Int, Int>()
        dp[0] = 0

        weights.forEachIndexed { index, weight ->
            val value = values[index]

            // 値が入っているものだけを取得
            val notNullList = dp.mapNotNull { it.key to it.value }.sortedBy { it.first } // 処理を追いやすいようにSortをかけている。実運用ではSortを外す

            notNullList.forEach {
                val prevWeight = it.first
                val prevValue = it.second

                val nextIndex = prevWeight + weight
                val nextValue = prevValue + value
                dp[nextIndex] = max(dp[nextIndex], nextValue) // 既に格納されていた場合、大きい方を入れる
            }
        }
        return dp[weightMax].toIntNullable()
    }

    /**
     * 価値が大きいもの優先： ある重さにおける最大の価値を優先
     * 配列バージョン、メモリ必要
     */
    fun prioritizeHighValue2(weights: List<Int>, values: List<Int>, weightMax: Int): Int {
        val dp: Array<Int?> = arrayOfNulls<Int?>(weightMax + 20)
        dp[0] = 0

        weights.forEachIndexed { index, weight ->
            val value = values[index]
            val notNullList = dp.mapIndexedNotNull { i, it -> if (it != null) i to it else null }

            notNullList.forEach {
                val prevWeight = it.first
                val prevValue: Int = it.second

                val nextIndex = prevWeight + weight
                val nextValue = prevValue + value
                dp[nextIndex] = max(dp[nextIndex], nextValue) // 既に格納されていた場合、大きい方を入れる
            }
        }
        return dp[weightMax].toIntNullable()
    }
}

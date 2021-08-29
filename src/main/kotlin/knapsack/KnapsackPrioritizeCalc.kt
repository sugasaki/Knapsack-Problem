package knapsack

import max
import toIntNullable

/**
 * ナップサック問題
 * 価値が大きいもの優先： ある重さにおける最大の価値を優先
 * 順番に埋めていく
 * メモリを省エネするためにHashを使っています
 */
object KnapsackPrioritizeCalc {

    /**
     * 価値が大きいもの優先： ある重さにおける最大の価値を優先
     * HashTableを使ってメモリを節約するバージョン
     */
    fun calc(weights: List<Int>, values: List<Int>, weightMax: Int): Int {
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

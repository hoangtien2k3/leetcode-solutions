package array._118PascalTriangle

/**
 * @author: hoangtien2k3
 * @create: 28/01/2024 - 23:43
 * @file: _118PascalTriangle_kotlin.kt
 * @update: 28/01/2024
 * @description:
 */
class Solution_kotlin {
    fun generate(numRows: Int): List<List<Int>> {
        return generateSequence(mutableListOf(1)) { row ->
            val size = row.size + 1
            (0 until size).mapTo(ArrayList()) { i ->
                if (i == 0 || i == size - 1) 1 else row[i-1] + row[i]
            }
        }.take(numRows).toList()
    }
}

fun main() {
    val solution: Solution_kotlin = Solution_kotlin()
    println(solution.generate(5))
}

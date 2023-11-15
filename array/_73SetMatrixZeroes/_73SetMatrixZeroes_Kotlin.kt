package array._73SetMatrixZeroes

class Solution_Kotlin {
    fun setZeroes(matrix: Array<IntArray>) {
        val m = matrix.size
        val n = matrix[0].size

        val rowHasZero = BooleanArray(m)
        val colHasZero = BooleanArray(n)

        // Đánh dấu hàng và cột cần biến thành 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (matrix[i][j] == 0) {
                    rowHasZero[i] = true
                    colHasZero[j] = true
                }
            }
        }

        // Biến đổi ma trận
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (rowHasZero[i] || colHasZero[j]) {
                    matrix[i][j] = 0
                }
            }
        }
    }
}


fun main() {
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 0, 6),
        intArrayOf(7, 8, 9)
    )

    val solution: Solution_Kotlin = Solution_Kotlin()
    solution.setZeroes(matrix)

    for(i in 0 until matrix.size) {
        for(j in 0 until matrix[i].size) {
            print("${matrix[i][j]} ")
        }
        println()
    }
}


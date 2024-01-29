package array._69Sqrt

import array._118PascalTriangle.Solution_kotlin

class Solution_kotlin_Sqrt {

    fun mySqrt(x: Int): Int {

        if (x == 0 || x == 1) return x;

        var start = 1;
        var end = x;
        var mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid * mid > x) {
                end = mid -1;
            } else if (mid * mid < x) {
                start = mid + 1
            } else {
                return mid
            }
        }

        return end;
    }


}

fun main() {
    val solution: Solution_kotlin_Sqrt = Solution_kotlin_Sqrt()
    println(solution.mySqrt(4))
}
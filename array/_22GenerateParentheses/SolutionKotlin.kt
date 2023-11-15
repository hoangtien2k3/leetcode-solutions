package array._22GenerateParentheses

class SolutionKotlin {
    private fun recursionParenthesis(res: MutableList<String>, left: Int, right: Int, s: String, n: Int) {
        if (s.length == n * 2) {
            res.add(s)
            return
        }
        if (left < n) {
            recursionParenthesis(res, left + 1, right, "$s(", n)
        }
        if (right < left) {
            recursionParenthesis(res, left, right + 1, "$s)", n)
        }
    }

    fun generateParenthesis(n : Int): List<String> {
        val list = mutableListOf<String>()
        recursionParenthesis(list, 0, 0, "", n)
        return list
    }
}

fun main(args: Array<String>) {
    val n = 3

    val solution = SolutionKotlin()
    val result = solution.generateParenthesis(n)
    println("${result.toString()}")
}
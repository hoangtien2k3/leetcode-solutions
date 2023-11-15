package array._17LetterCombinationsOfAPhoneNumber

class SolutionKotlin {
    private fun backtrackingPhoneNumber(temp: List<String>, allList: List<String>, digits: String, check: String, index: Int): List<String> {
        if (digits.length == check.length) {
            return allList + listOf(check)
        }
        val currentListNumber = temp.get(digits[index] - '0')
        var resultList = allList
        for(i in currentListNumber.indices) {
            resultList = backtrackingPhoneNumber(temp, resultList, digits, check + currentListNumber[i], index + 1)
        }
        return resultList
    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }

        val allList: List<String> = listOf()
        val temp: List<String> = listOf("", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        return backtrackingPhoneNumber(temp, allList, digits, "", 0)
    }
}

fun main(args: Array<String>) {
    val digits: String = "23"

    val solution: SolutionKotlin = SolutionKotlin()
    val result: List<String> = solution.letterCombinations(digits)
    println(result.toString())

}

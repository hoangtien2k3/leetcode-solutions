package array._3LongestSubstringWithoutRepeatingCharacters

class SolutionKotlin {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = mutableSetOf<Char>()
        var maxLength = 0
        var left = 0
        var right = 0

        while (right < s.length) {
            val c = s[right]
            if (!set.contains(c)) {
                set.add(c)
                maxLength = maxLength.coerceAtLeast(right - left + 1)
                right++
            } else {
                set.remove(s[left])
                left++
            }
        }

        return maxLength
    }
}

fun main() {
    val input = "abcabcbb"
    val solution: SolutionKotlin = SolutionKotlin()
    val result = solution.lengthOfLongestSubstring(input)
    println("${result}")
}
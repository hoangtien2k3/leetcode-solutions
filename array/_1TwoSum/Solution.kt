package array._1TwoSum

class SolutionKotlin {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map: MutableMap<Int, Int> = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            val complement = target - nums[i]
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            }
            map[nums[i]] = i
            // map.put(nums[i], i)
        }
        throw IllegalArgumentException("No two sum solution")
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

    val solution = SolutionKotlin()
    val result = solution.twoSum(nums, target)

    println("${result.contentToString()}")
}
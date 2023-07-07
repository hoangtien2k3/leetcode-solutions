package Array._88MergeSortedArray

class SolutionKotlin {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while(j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--]
            } else {
                nums1[k--] = nums2[j--]
            }
        }
    }
}

fun main(args: Array<String>) {
    val nums1: IntArray = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3
    val nums2: IntArray = intArrayOf(2, 5, 6)
    val n = 3

    val solution = SolutionKotlin()
    solution.merge(nums1, m, nums2, n)

    for(i in nums1.indices) {
        if (i == nums1.size - 1) {
            print("${nums1[i]}")
            break
        }
        print("${nums1[i]}, ")
    }
}
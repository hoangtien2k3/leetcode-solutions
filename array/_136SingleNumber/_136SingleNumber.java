package array._136SingleNumber;

import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        // cách 1:
//        for(int i = 0; i < nums.length; i++) {
//            int c = 0;
//            for(int j = 0; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    c++;
//                }
//            }
//            if (c == 1) {
//                return nums[i];
//            }
//        }
//        return 0;


        // cách 2
//        return Arrays.stream(nums)
//                .filter(num -> Arrays
//                        .stream(nums)
//                        .filter(n -> n == num)
//                        .count() == 1
//                )
//                .findFirst()
//                .orElseThrow(() -> new RuntimeException("No unique number found"));


        // cách 3: dùng set
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (!set.add(num)) {
//                set.remove(num);
//            }
//        }
//        return set.iterator().next();


        // cách 4: Sử dụng XOR => áp dụng tính chất của XOR (VD: 3 ^ 3 = 0, 0 ^ 3 = 3)
//        int result = 0;
//        for (int num : nums) {
//            result ^= num;
//        }
//        return result;


        // cách 5: sử dụng hash map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        return -1;

    }
}

public class _136SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 2, 1};
        System.out.println(solution.singleNumber(nums));
    }
}

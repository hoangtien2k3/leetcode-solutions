package array._1426CountingElements;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countElements(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for (int a : arr) {
            s.add(a);
        }

        int ans = 0;
        for (int a : arr) {
            if (s.contains(a + 1)) {
                ++ans;
            }
        }

        return ans;
    }
}


public class _1426CountingElements {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3};
        System.out.println(solution.countElements(arr));
    }
}

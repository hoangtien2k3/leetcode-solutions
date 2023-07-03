package Array._70ClimbingStairs;

class Solution {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

public class _70ClimbingStairs {
    public static void main(String[] args) {
        int n = 45;
        System.out.println(Solution.climbStairs(n));
    }
}

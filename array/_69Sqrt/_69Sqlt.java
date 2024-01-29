package array._69Sqrt;

class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int start = 1;
        int end = x;
        int mid = - 1;

        while(start <= end) {
            mid = start + (end - start)/2;
            if ((long) mid * mid > (long) x) {
                end = mid - 1;
            } else if ((long) mid * mid < (long) x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return Math.round(end);
    }
}

public class _69Sqlt {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.mySqrt(4));
    }
}

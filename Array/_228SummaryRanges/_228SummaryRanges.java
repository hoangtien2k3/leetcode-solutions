package Array._228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums.length == 1) {
            String s = Integer.toString(nums[0]);
            list.add(s);
            return list;
        }

        // 0,1,2,4,5,7
        String result = "";
        for (int i = 0; i < nums.length; i++) {
            int count = i;
            while(count + 1 < nums.length && nums[count + 1] == nums[count] + 1) {
                count++;
            }
            // kiểm tra xem giá trị có trùng nhau hay không
            if (count > i) { // nếu giá trị không trùng lặp
                result = Integer.toString(nums[i]) + "->" + Integer.toString(nums[count]);
            } else {
                result = Integer.toString(nums[i]);
            }
            list.add(result);
            result = "";
            // giờ thì index sẽ nhảy tới vị trí thứ count mà chúng ta vừa lặp tới.
            i = count;
        }

        return list;
    }
}

public class _228SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        List<String> list = Solution.summaryRanges(nums);
        for(String s : list) {
            System.out.println(s + "");
        }
    }
}

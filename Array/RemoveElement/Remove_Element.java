
// 27. Remove Element

package Array.RemoveElement;

class Solution {
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for(int i = 0; i < nums.length ; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}

public class Remove_Element {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = new int[]{0,1,2,2,3,0,4,2} ;
        int val = 2;

        System.out.println(solution.removeElement(nums, val));
    }
}

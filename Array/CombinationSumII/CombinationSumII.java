package Array.CombinationSumII;

import javax.naming.PartialResultException;
import javax.swing.plaf.SliderUI;
import java.lang.reflect.Array;
import java.util.*;

//! Solution 1
class Solution {
    private void search(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] > target) {
                break;
            }
            temp.add(nums[i]);
            search(list, temp, nums, target - nums[i], i + 1);

            // loại bỏ phần tử không thỏa mãn ở cuối ArrayList khi thêm vào. (để có thể test hay thử giá trị tiếp theo)
            // mỗi lần nó sẽ gọi Backtrack lại hàm và thay đổi giá trị(loại bỏ giá trị không thỏa mãn khi đây vào trong ArrayList
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        search(list, new ArrayList<>(), nums, target, 0);
        return list;
    }
}


//! Solution 2
//class Solution {
//    public List<List<Integer>> combinationSum2(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//
//        Stack<State> stack = new Stack<>();
//        stack.push(new State(new ArrayList<>(), 0));
//        while (!stack.isEmpty()) {
//            State state = stack.pop(); // stack.pop() là đấy ra đối tượng kiểu State ở đầu ngăn xếp.
//            List<Integer> combination = state.combination; // lấy ra list: combination
//            int start = state.start; // lấy ra điểm bắt đầu: start
//
//            int sum = combination.stream().mapToInt(Integer::intValue).sum(); // tính tổng từng giá trị trong list: combination
//
//            if (sum == target) {
//                result.add(new ArrayList<>(combination)); // add toàn bộ list<list>: result
//            } else if (sum < target) {
//
//                for (int i = start; i < nums.length; i++) {
//                    if (i > start && nums[i] == nums[i - 1]) { // nếu các phần tử trung lặp.
//                        continue; // bỏ qua phần tử đó
//                    }
//
//                    if (nums[i] > target - sum) { // tổng các phần tử trong list đã vượt qua target ban đầu.
//                        break;
//                    }
//
//                    combination.add(nums[i]); // đẩy toàn bộ list vào list<list>
//
//                    stack.push(new State(new ArrayList<>(combination), i + 1)); // đẩy đối tượng combination vào Start vào trong Stack
//                    combination.remove(combination.size() - 1); //
//                }
//            }
//        }
//        return result;
//    }
//
//    private static class State {
//        List<Integer> combination;
//        int start;
//        public State(List<Integer> combination, int start) {
//            this.combination = combination;
//            this.start = start;
//        }
//    }
//}



//! Solution 3
//class Solution {
//    public static List<List<Integer>> combinationSum2(int[] nums, int target) {
//        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(nums);
//        backtrack(nums, target, 0, new Stack<>(), result);
//        return result;
//    }
//    private static void backtrack(int[] nums, int target, int start, Stack<Integer> stack, List<List<Integer>> result) {
//        if (target == 0) {
//            result.add(new ArrayList<>(stack));
//            return;
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (i > start && nums[i] == nums[i-1]) {
//                continue;
//            }
//            if (nums[i] > target) {
//                break;
//            }
//            stack.push(nums[i]);
//            backtrack(nums, target - nums[i], i+1, stack, result);
//            stack.pop();
//        }
//    }
//}

public class CombinationSumII {
    public static void main(String[] args) {
        int[] nums = new int[] {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(nums, target));
    }
}

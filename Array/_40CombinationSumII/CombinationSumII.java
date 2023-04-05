package Array._40CombinationSumII;

import java.util.*;

//! Solution 1
class Solution {
    private void search(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(temp)); // push temp into list
            return; // stop backtrack
        }
        for(int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) {
                continue; // ignore duplicate elements
            }
            if (nums[i] > target) {
                break; // exit for loop
            }
            temp.add(nums[i]); // add into list temp
            search(list, temp, nums, target - nums[i], i + 1); // backtrack again
            temp.remove(temp.size() - 1); // remove the element at the end
        }
    }

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums); // sort nums
        search(list, new ArrayList<>(), nums, target, 0); // call function
        return list; // return result
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

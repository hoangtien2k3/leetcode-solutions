package Array._39CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);

        // [2,3,6,7], target = 7
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
        }



        return list;
    }
}



public class _39CombinationSum {

}

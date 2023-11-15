package string._139WordBreak;

import java.util.*;

class Solution {
    public boolean checkWordDirt(String s, Set<String> set, Map<String, Boolean> map) {

        if (s.isEmpty()) return true;
        if (map.containsKey(s)) return map.get(s); // return boolean trong map

        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(0, i + 1))         // giá trị từ 0 -> (i + 1)
                    && (set.contains(s.substring(i + 1))    // giá trị từ (i + 1) -> s.length
                    || checkWordDirt(s.substring(i + 1), set, map))) {      // gọi đệ quy
                map.put(s, true);
                return true;
            }
        }

        map.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> dict) {
        Set<String> st = new HashSet<>(dict);
        Map<String, Boolean> mp = new HashMap<>();
        return checkWordDirt(s, st, mp);
    }
}

public class _139WordBreak {
    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");

        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, list));
    }
}
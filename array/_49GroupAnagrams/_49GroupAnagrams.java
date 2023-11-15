/*
*   49. Group Anagrams
*
* */

package array._49GroupAnagrams;


import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> map = new HashMap<>();

        for(String e : strs){
            char[] ch = e.toCharArray(); // chuyển chuỗi thành mảng ky tự.
            Arrays.sort(ch); // mục đích chuyển về mảng ký tự để Sort.

            String str = new String(ch); // chuyền mảng ký tự vào chuỗi.

            if(!map.containsKey(str)){
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(e);
            // [[eat, tea, ate], [tan, nat], [bat]]
        }

        return new ArrayList<>(map.values());
    }
}

public class _49GroupAnagrams {
    public static void main(String[] args) {
        String[] s = {"eat","tea","tan","ate","nat","bat"};
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(s));
    }
}

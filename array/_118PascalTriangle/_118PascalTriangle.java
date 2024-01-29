package array._118PascalTriangle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: hoangtien2k3
 * @create: 28/01/2024 - 23:42
 * @file: _118PascalTriangle.java
 * @update: 28/01/2024
 * @description:
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {

        // cách 1:
//        List<List<Integer>> list = new ArrayList<>();
//
//        for(int i = 0; i < numRows; i++) {
//
//            List<Integer> subList = new ArrayList<>();
//
//            for(int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    subList.add(1);
//                } else {
//                    int value = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
//                    subList.add(value);
//                }
//            }
//
//            list.add(subList);
//        }
//
//        return list;


        // cách 2: stream api
        return Stream.iterate(List.of(1), row -> {
            int size = row.size() + 1;
            return IntStream.range(0, size)
                    .mapToObj(i -> (i == 0 || i == size - 1) ? 1 : row.get(i - 1) + row.get(i))
                    .collect(Collectors.toCollection(ArrayList::new));
        }).limit(numRows).toList();

    }
}

public class _118PascalTriangle {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }

}

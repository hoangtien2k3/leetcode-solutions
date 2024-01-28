package array._118PascalTriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: hoangtien2k3
 * @create: 28/01/2024 - 16:04
 * @file: _118PascalTriangle.java
 * @update: 28/01/2024
 * @description: easy
 */
class Solution {

    // cách 1:
//    public List<List<Integer>> generate(int numRows) {
//        List<List<Integer>> list = new ArrayList<>();
//
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> sublist = new ArrayList<>();
//
//            for (int j = 0; j <= i; j++) {
//                if (j == 0 || j == i) {
//                    sublist.add(1); // add 1 vào vị trí đầu và cuối mảng
//                } else {
//                    int value = list.get(i - 1).get(j - 1) + list.get(i - 1).get(j);
//                    sublist.add(value);
//                }
//            }
//
//            list.add(sublist);
//        }
//
//        return list;
//    }

    // cách 2:
    public List<List<Integer>> generate(int numRows) {
        return Stream.iterate(new ArrayList<Integer>(List.of(1)), row -> {
                    int size = row.size() + 1;
                    return IntStream.range(0, size)
                            .mapToObj(i -> (i == 0 || i == size - 1) ? 1 : row.get(i - 1) + row.get(i))
                            .collect(Collectors.toCollection(ArrayList::new));
                })
                .limit(numRows)
                .collect(Collectors.toList());
    }

}

public class _118PascalTriangle {

    public static void main(String[] args) {
        Solution solution = new Solution();


        System.out.println(solution.generate(5));

        System.out.println("_".repeat(50));

        Stream.iterate(1, n -> n * 2)
                .limit(5)
                .forEach(System.out::println);

    }

}

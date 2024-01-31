package array._119PascalTriangleII;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public List<Integer> getRow(int rowIndex) {

        return Stream.iterate(new ArrayList<>(List.of(1)), row -> {
            int size = row.size() + 1;
            return IntStream.range(0, size)
                    .mapToObj(i -> (i == 0 || i == size - 1) ? 1 : row.get(i - 1) + row.get(i))
                    .collect(Collectors.toCollection(ArrayList::new));
        }).limit(rowIndex + 1)
                .reduce((first, second) -> second)
                .orElse( new ArrayList<>());

    }
}

public class _119PascalTriangleII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }
}

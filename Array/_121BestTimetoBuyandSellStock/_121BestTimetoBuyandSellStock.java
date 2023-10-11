package Array._121BestTimetoBuyandSellStock;

class Solution {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int min_prices = prices[0];
        int result = 0;

        int position = 1; // vị trí thứ 2

        for(int i = position; i < prices.length; i++) {
            if (prices[i] < min_prices) {
                // tìm ra giá thấp nhất
                min_prices = prices[i];
            } else {
                int max_prices = prices[i] - min_prices;
                result = Math.max(result, max_prices);
            }
        }

        return result;
    }
}

public class _121BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(Solution.maxProfit(prices));
    }
}
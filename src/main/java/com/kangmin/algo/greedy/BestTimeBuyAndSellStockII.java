package main.java.com.kangmin.algo.greedy;

public class BestTimeBuyAndSellStockII {

    // earn every profit we can earn
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }

        return total;
    }

    // deep thought
    public int maxProfitDeep(int[] prices) {
        int profit = 0, i = 0;
        while (i < prices.length) {
            // find next local minimum
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            int min = prices[i++]; // need increment to avoid infinite loop for "[1]"
            // find next local maximum
            while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                i++;
            }
            profit += i < prices.length ? prices[i++] - min : 0;
        }
        return profit;
    }
}

package com.avminin.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        if (prices.length >= 1) {
            int cur_max = prices[0];
            int cur_min = prices[0];

            for (int price : prices) {
                if (cur_max < price) {
                    if (max_profit < price - cur_min)
                        max_profit = price - cur_min;
                    cur_max = price;
                } else if (cur_min > price) {
                    cur_max = price;
                    cur_min = price;
                }
            }
        }

        return max_profit;
    }
}

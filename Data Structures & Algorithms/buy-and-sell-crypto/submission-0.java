class Solution {
    public int maxProfit(int[] prices) {
        int sell = 1;
        int buy = 0;

        int profit = 0;

        while (sell < prices.length) {
            if (prices[buy] < prices[sell]) {
                int localProfit = prices[sell] - prices[buy];
                profit = Math.max(profit, localProfit);
            } else {
                buy = sell;
            }
            sell++;
        }

        return profit;
    }
}


  
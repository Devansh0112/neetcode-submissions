class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length - 1;
        int[] totalCost = new int[n+1];
        if (n == 1) return Math.min(cost[0], cost[1]);

        totalCost[n] = cost[n];
        totalCost[n-1] = cost[n-1];

        for (int i=n-2; i >=0; i--) {
            totalCost[i] = Math.min(totalCost[i+1], totalCost[i+2]) + cost[i];
        }

        return Math.min(totalCost[0], totalCost[1]);
    }
}

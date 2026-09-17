// O(1) space version
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int oneBack = 2;
        int twoBack = 1;

        for(int i=2; i<n; i++) {
            int result = oneBack + twoBack;

            twoBack = oneBack;
            oneBack = result;

        }

        return oneBack;
    }
}

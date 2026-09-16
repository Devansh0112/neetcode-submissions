class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int i=0, j=heights.length-1;

        while(i<j) {
            int height = Math.min(heights[i], heights[j]);
            int width = j - i;

            maxArea = Math.max(maxArea, height*width);

            if(heights[i] <= heights[j]) i++;
            else j--;
        }

        return maxArea;
    }
}

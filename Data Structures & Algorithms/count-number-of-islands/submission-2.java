class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    markBoundary(grid, r, c);
                }
            }
        }
        return count;
    }

    private void markBoundary(char[][] grid, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') return;

        grid[r][c] = '0';

        markBoundary(grid, r+1, c);
        markBoundary(grid, r-1, c);
        markBoundary(grid, r, c+1);
        markBoundary(grid, r, c-1);
    }
}

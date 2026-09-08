class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        Set<List<Integer>> visited = new HashSet<>();
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if(grid[r][c] == '1' && !visited.contains(Arrays.asList(r,c))) {
                    count++;
                    markBoundary(grid, r, c, visited);
                }
            }
        }
        return count;
    }

    private void markBoundary(char[][] grid, int r, int c, Set<List<Integer>> visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited.contains(Arrays.asList(r,c)) || grid[r][c] == '0') return;

        visited.add(Arrays.asList(r,c));

        markBoundary(grid, r+1, c, visited);
        markBoundary(grid, r-1, c, visited);
        markBoundary(grid, r, c+1, visited);
        markBoundary(grid, r, c-1, visited);
    }
}

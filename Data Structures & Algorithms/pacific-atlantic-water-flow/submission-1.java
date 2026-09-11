// BFS solution

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            bfs(heights, pacific, i, 0);
            bfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            bfs(heights, pacific, 0, j);
            bfs(heights, atlantic, m - 1, j);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }

    private void bfs(int[][] heights, boolean[][] visited, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curs = queue.poll();
            for (int[] d : dirs) {
                int nr = curs[0] + d[0], nc = curs[1] + d[1];
                if (nr < 0 || nr >= heights.length || nc < 0 || nc >= heights[0].length)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (heights[nr][nc] < heights[curs[0]][curs[1]])
                    continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
            }
        }
    }
}

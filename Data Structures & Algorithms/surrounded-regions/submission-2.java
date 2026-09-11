// bfs iterative version

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = i == 0 || i == m - 1 || j == 0 || j == n - 1;
                if (isBorder && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'Y')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r, c});
        board[r][c] = 'Y';

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0], nc = cur[1] + dir[1];
                if(nr<0||nr>=board.length||nc<0||nc>=board[0].length) continue;
                if(board[nr][nc] != 'O') continue;

                board[nr][nc] = 'Y';
                q.offer(new int[]{nr,nc});
            }
        }
    }
}

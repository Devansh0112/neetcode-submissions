//dfs recursion

class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                boolean isBorder = i==0 || i == m-1 || j ==0 || j==n-1;
                if(isBorder && board[i][j] == 'O') {
                    dfs(board, i, j);
                } 
            }
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int r, int c) {
        if(r<0||r>=board.length||c<0||c>=board[0].length) return;
        if(board[r][c] != 'O') return;
        board[r][c] = 'Y';

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0, -1}};

        for(int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            dfs(board, nr, nc);
        }
    }
}

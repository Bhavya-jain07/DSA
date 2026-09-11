class Solution {
    int MOD = 1_000_000_007;
    public int countPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Integer[][] dp = new Integer[n][m];
        int paths = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                paths = (paths + solve(grid, i, j, dp)) % MOD;
            }
        }
        return paths;
    }
    public int solve(int[][] grid, int row, int col, Integer[][] dp){   
        if(dp[row][col]!=null){
            return dp[row][col];
        }
        int val = 0;
        int []r = {-1, 1, 0, 0};
        int []c = {0, 0, -1, 1};
        for(int i =0; i<r.length; i++){
            int nr = row+r[i];
            int nc = col+ c[i]; 
            if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[row][col]>=grid[nr][nc]){
                continue;
            }
            val = val+solve(grid, nr, nc, dp)%MOD;
        }
        return dp[row][col] = (1+val)%MOD;
    }
}
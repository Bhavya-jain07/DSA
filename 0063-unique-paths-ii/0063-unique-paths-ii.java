class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        if(grid[m][n] == 1) return 0;
        int[][] dp = new int[m+1][n+1];
        for (int[] x : dp){
            Arrays.fill(x, -1);
        }
        return recur(0, 0, m , n ,grid, dp);
    }
    private int recur(int i, int j, int m, int n, int [][] grid, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        if(grid[i][j] != 1){
        int down = recur(i + 1, j, m, n, grid, dp);
        int right = recur(i, j + 1, m, n, grid, dp);
        ans = down + right;
        }
        return dp[i][j] = ans;
    }
}
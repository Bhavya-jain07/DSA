class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] x : dp){
            Arrays.fill(x, -1);
        }
        return recur(0, 0, m - 1, n - 1, dp);
    }

    private int recur(int i, int j, int m, int n, int[][] dp) {
        if (i == m && j == n) {
            return 1;
        }
        if (i > m || j > n)
            return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int ans = 0;
        int down = recur(i + 1, j, m, n, dp);
        int right = recur(i, j + 1, m, n, dp);
        return dp[i][j] = down + right;
    }

}
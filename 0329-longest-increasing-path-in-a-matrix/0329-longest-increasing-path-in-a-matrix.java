class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Integer [][] dp = new Integer[n+1][m+1];
        int max = 1;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                max = Math.max(max,solve(matrix, i, j, dp));
            }
        }
        return max;
    }
    private int solve(int [][] mat, int row, int col, Integer [][] dp){
        int max = 1;
        int [] r ={1, 0, -1, 0}; 
        int [] c ={0, 1, 0, -1}; 
        if(dp[row][col] != null) return dp[row][col];
        for(int i = 0; i<r.length; i++){
            int nr = row+r[i];
            int nc = col+c[i];
            if(nr < 0 || nr>= mat.length|| nc <0 || nc>=mat[0].length||mat[row][col]>=mat[nr][nc]) continue;
            max = Math.max(max, 1+solve(mat, nr, nc, dp));
        }
        return dp[row][col] = max;
    }
}
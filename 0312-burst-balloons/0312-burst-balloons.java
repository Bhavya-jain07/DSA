class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int [] arr = new int [n+2];
        arr[0] = arr[n+1] = 1;
        for (int i = 0; i < n; i++)
            arr[i + 1] = nums[i];
        int [][]dp = new int [n+1][n+1];
        for(int []x:dp){
        Arrays.fill(x, -1);
        }
        return recur(1, n, dp,arr);
    }
    private int recur(int i, int j, int [][] dp, int [] arr){
        if(i>j) return 0;
        int ans = 0;
        if(dp[i][j] != -1) return dp[i][j];
        for(int k = i; k<=j; k++){
        int left = recur(i,k-1,dp,arr);
        int right = recur(k+1,j,dp,arr);
        int current = arr[i-1]*arr[k]*arr[j+1];
        ans = Math.max(ans,current+left+right);
        dp[i][j] = ans;
        }
        return dp[i][j];
    }
}
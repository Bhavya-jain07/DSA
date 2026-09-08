class Solution {
    public int minFlipsMonoIncr(String s) {
        Integer [][] dp = new Integer[2][s.length()];
        return solve(s, 0, 0,dp);
    }
    private int solve(String s, int prev, int i, Integer[][]dp) {
        if (i >= s.length()) {
            return 0;
        }
        if(dp[prev][i] != null){
            return dp[prev][i];
        }
        int change = Integer.MAX_VALUE;
        int keep = Integer.MAX_VALUE;
        if (prev == 0) {
            if (s.charAt(i) == '0') {
                keep = solve(s, 0, i + 1, dp);
            } else {
                change = 1 + solve(s, 0, i + 1, dp);
            }
        }
        if (s.charAt(i) == '1') {
            keep = Math.min(keep, solve(s, 1, i + 1, dp));
        } else {
            change = Math.min(change, 1 + solve(s, 1, i + 1, dp));
        }
        return dp[prev][i] = Math.min(change, keep);
    }
}
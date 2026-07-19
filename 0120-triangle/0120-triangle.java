class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer [][] dp = new Integer [triangle.size()][triangle.get(triangle.size()-1).size()];
        return recur(0,0,triangle,dp);
    }
    private int recur(int i, int j, List<List<Integer>> list, Integer [][]dp){
        if(i == list.size() || j == list.get(list.size()-1).size()) return 0;
        if(dp[i][j] != null) return dp[i][j]; 
        int sum = 0;
        int a = list.get(i).get(j) + recur(i+1, j, list,dp); 
        int b = list.get(i).get(j) + recur(i+1, j+1, list,dp);
        dp[i][j] = Math.min(a,b);
        return dp[i][j]; 
    }   
}
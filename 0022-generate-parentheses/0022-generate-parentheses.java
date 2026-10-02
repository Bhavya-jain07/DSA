class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ll = new ArrayList<>();
        solve("",0,0,n,ll);
        return ll;
    }
    public static void solve(String ans,int open, int close, int n, List<String> ll){
        if(open == n && close == n){
            ll.add(ans);
            return;
        }
        if(open>n||close>open) return;

        solve(ans+"(",open+1,close,n,ll);
        solve(ans+")",open,close+1,n,ll);
    }
}
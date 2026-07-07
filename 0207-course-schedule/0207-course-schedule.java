class Solution {
    public boolean canFinish(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<num; i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge : pre){
            int course = edge[0];
            int prereq = edge[1];
            adj.get(prereq).add(course);
        }
        boolean [] vis = new boolean [num];
        boolean [] path = new boolean [num];
        for(int i = 0; i<num; i++){
            if(!vis[i]){
                if(dfs(i,adj,path,vis)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean [] path, boolean [] vis){
        vis[node] = true;
        path[node] = true;
        for(int nbr:adj.get(node)){
            if(!vis[nbr]){
                if(dfs(nbr,adj,path,vis)) return true;
            }
            else if(path[nbr]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}
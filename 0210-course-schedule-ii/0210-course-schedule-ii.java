class Solution {
    public int[] findOrder(int num, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < num; i++)
            adj.add(new ArrayList<>());
        int [] indegree = new int[num];
        for(int[] edge : pre){
            int course = edge[0];
            int prereq = edge[1];
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        int[] ans = new int[num];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<num; i++){
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node; 
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0) q.add(it);
            }
        }
    return idx == num ? ans : new int[0];
    }
}
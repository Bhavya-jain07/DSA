class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ll = new ArrayList<>();
        int n = heights.length;
        int m = heights[0].length;
        Queue<int[]> atl = new LinkedList<>();
        Queue<int[]> pac = new LinkedList<>();
        int[][] atlant = new int[n][m];
        int[][] pacific = new int[n][m];
        for (int i = 0; i < m; i++) {
            pac.add(new int[] { 0, i });
            pacific[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            pac.add(new int[] { i, 0 });
            pacific[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            atl.add(new int[] { i, m - 1 });
            atlant[i][m - 1] = 1;
        }
        for (int i = 0; i < m; i++) {
            atl.add(new int[] { n - 1, i });
            atlant[n - 1][i] = 1;
        }
        bfs(atl, atlant, heights);
        bfs(pac, pacific, heights);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(atlant[i][j] == 1 && pacific[i][j] ==1){
                    ll.add(Arrays.asList(i,j));
                }
            }
        }
    return ll;
    }

    private void bfs(Queue<int[]> q, int[][] visited, int[][] heights) {
        int [] rr = {1,-1,0,0};
        int [] cc = {0,0,-1,1};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i = 0; i<rr.length; i++){
                int nr = r+rr[i];
                int nc = c+cc[i];
                if(nc<0 || nr<0 ||nc>=visited[0].length ||nr>=visited.length || visited[nr][nc] ==1){
                    continue;
                }
                if(heights[r][c]<=heights[nr][nc]){
                    visited[nr][nc] = 1;
                    q.add(new int[]{nr,nc});
                }
            }

        }
    }
}
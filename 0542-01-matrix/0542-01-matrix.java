class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        boolean [][] vis = new boolean [n][m];
        int [][] dist = new int [n][m];
        Queue<int[]> q= new LinkedList<>();
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat [i][j] == 0){
                    q.add(new int[]{i,j});
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        int [] dir = {0,1,0,-1,0};
        while(!q.isEmpty()){
            int [] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i =0; i<4; i++){
            int nr = r+dir[i];
            int nc = c+dir[i+1];
            if (nr >= 0 && nr <= vis.length-1  && nc >= 0 && nc <= vis[0].length-1 && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }

            }
        }
        return dist;
    }
}
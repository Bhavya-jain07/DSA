class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int prev = image[sr][sc];
        if (color == prev) return image;
        dfs(image,sr,sc,color,prev);
        return image;
    }
    private void dfs(int[][] grid, int sr, int sc, int clr, int prev){
        if(sr>grid.length-1 || sc>grid[0].length-1 || sr<0 || sc<0 || grid[sr][sc]!= prev){
            return;
        }
        int []r = {1,-1,0,0};
        int []c = {0,0,-1,1};
        for(int i =0; i<r.length; i++){
            grid[sr][sc] = clr;
            int nr = sr+r[i];
            int nc = sc+c[i];
            dfs(grid, nr, nc, clr, prev);
        }

    }
}
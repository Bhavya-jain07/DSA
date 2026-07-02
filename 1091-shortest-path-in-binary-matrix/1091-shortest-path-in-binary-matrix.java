class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[] row = { 1, -1, 0, 0, 1, -1, 1, -1 };
        int[] col = { 0, 0, -1, 1, 1, 1, -1, -1 };
        if (grid[0][0] == 1)
            return -1;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int d = curr[2];
            if (r == n - 1 && c == m - 1)
                return d;
            for (int i = 0; i < row.length; i++) {
                int nr = r + row[i];
                int nc = c + col[i];
                if (nr >= 0 && nc >= 0 && nr <= grid.length - 1 && nc <= grid[0].length - 1 && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    q.add(new int[] { nr, nc, d + 1 });
                }
            }
        }
        return -1;
    }
}
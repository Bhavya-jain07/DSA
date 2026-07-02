class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = grid.get(i).get(j);
            }
        }
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dist[0][0] = mat[0][0];
        pq.offer(new int[]{dist[0][0], 0, 0});
        int[] row = {1, -1, 0, 0};
        int[] col = {0, 0, 1, -1};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int dis = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (dis > dist[r][c]) continue;
            for (int k = 0; k < 4; k++) {
                int nr = r + row[k];
                int nc = c + col[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int newDist = dis + mat[nr][nc];
                    if (newDist < dist[nr][nc]) {
                        dist[nr][nc] = newDist;
                        pq.offer(new int[]{newDist, nr, nc});
                    }
                }
            }
        }
        return dist[n - 1][m - 1] < health;
    }
}
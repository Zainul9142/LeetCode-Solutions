class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int islandCount = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long currentSum = 0;
                    
                    java.util.Queue<Integer> queue = new java.util.LinkedList<>();
                    queue.offer(i * n + j);
                    
                    currentSum += grid[i][j];
                    grid[i][j] = 0;

                    while (!queue.isEmpty()) {
                        int pos = queue.poll();
                        int r = pos / n;
                        int c = pos % n;

                        for (int[] d : dirs) {
                            int nr = r + d[0];
                            int nc = c + d[1];

                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                                currentSum += grid[nr][nc];
                                grid[nr][nc] = 0;
                                queue.offer(nr * n + nc);
                            }
                        }
                    }

                    if (currentSum % k == 0) {
                        islandCount++;
                    }
                }
            }
        }

        return islandCount;
    }
}
class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        if (checkHorizontalCuts(grid)) return true;
        return checkHorizontalCuts(transpose(grid));
    }
    private boolean checkHorizontalCuts(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long totalSum = 0;
        Map<Integer, Integer> topCounts = new HashMap<>();
        Map<Integer, Integer> bottomCounts = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += grid[i][j];
                bottomCounts.put(grid[i][j], bottomCounts.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        long s1 = 0; 
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                s1 += val;
                topCounts.put(val, topCounts.getOrDefault(val, 0) + 1);
                
                bottomCounts.put(val, bottomCounts.get(val) - 1);
                if (bottomCounts.get(val) == 0) bottomCounts.remove(val);
            }

            long s2 = totalSum - s1; 
            if (s1 == s2) return true;
            if (s1 > s2) {
                long diff = s1 - s2;
                if (diff <= Integer.MAX_VALUE && 
                    canRemove(grid, (int)diff, 0, i, 0, n - 1, topCounts)) {
                    return true;
                }
            } 
            else {
                long diff = s2 - s1;
                if (diff <= Integer.MAX_VALUE && 
                    canRemove(grid, (int)diff, i + 1, m - 1, 0, n - 1, bottomCounts)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean canRemove(int[][] grid, int target, int r1, int r2, int c1, int c2, Map<Integer, Integer> counts) {
        int h = r2 - r1 + 1;
        int w = c2 - c1 + 1;
        if (h * w <= 1) return false;

        if (h > 1 && w > 1) {
            return counts.containsKey(target);
        } else if (h == 1) {
            return grid[r1][c1] == target || grid[r1][c2] == target;
        } else {
            return grid[r1][c1] == target || grid[r2][c1] == target;
        }
    }
    private int[][] transpose(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] res = new int[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                res[c][r] = grid[r][c];
            }
        }
        return res;
    }
}
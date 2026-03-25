class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int[] row: grid){
            for(int val: row){
                total += val;
            }
        }
        if(total % 2 != 0) return false;
        long curr = 0;
        for (int i = 0; i < m - 1; i++) {
            long rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += grid[i][j];
            }
            curr += rowSum;

            if (curr * 2 == total) return true;
        }
        long currCol = 0;
        for (int j = 0; j < n - 1; j++) {
            long colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += grid[i][j];
            }
            currCol += colSum;

            if (currCol * 2 == total) return true;
        }
        return false;
    }
}
class Solution {
    private int getMinDiffInSubmatrix(int[][] grid, int row, int col, int k){
        int[] elements = new int[k*k];
        int idx = 0;
        for(int r = row;r < row+k;r++){
            for(int c= col;c <col+k;c++){
                elements[idx++] = grid[r][c];
            }
        }

        Arrays.sort(elements);
        int minDiff = Integer.MAX_VALUE;
        boolean foundDistinct = false;
        for(int i=1;i<elements.length;i++){
            if(elements[i] != elements[i-1]){
                int diff = elements[i] - elements[i-1];
                minDiff = Math.min(minDiff,diff);
                foundDistinct = true;
            }
        }

        return foundDistinct ? minDiff : 0;
    }
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m-k+1][n-k+1];
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                ans[i][j] = getMinDiffInSubmatrix(grid, i,j,k);
            }
        }
        return ans;
    }
}
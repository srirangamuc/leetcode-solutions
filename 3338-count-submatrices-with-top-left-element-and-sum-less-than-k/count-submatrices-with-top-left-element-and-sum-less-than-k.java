class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int r = 0;r<rows;r++){
            for(int c = 0;c < cols;c++){
                if(r > 0) grid[r][c] += grid[r-1][c];
                if(c > 0) grid[r][c] += grid[r][c-1];
                if(r > 0 && c > 0) grid[r][c] -= grid[r-1][c-1];
                if(grid[r][c] <= k) count++;
                else{
                    if(c == 0) return count;
                    break;
                }
            }
        }
        return count;
    }
}
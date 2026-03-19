class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] prefixX = new int[rows+1][cols+1];
        int[][] prefixY = new int[rows+1][cols+1];
        int result = 0;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=cols;j++){
                int isX = (grid[i-1][j-1] == 'X') ? 1 : 0;
                int isY = (grid[i-1][j-1] == 'Y') ? 1 : 0;
                prefixX[i][j] = prefixX[i-1][j] + prefixX[i][j-1] - prefixX[i-1][j-1] + isX;
                prefixY[i][j] = prefixY[i-1][j] + prefixY[i][j-1] - prefixY[i-1][j-1] + isY;
                if(prefixX[i][j] == prefixY[i][j] && prefixX[i][j] > 0){
                    result++;
                }
            }
        }   
        return result;
    }
}
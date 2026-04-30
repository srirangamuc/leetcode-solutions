class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int startVal = grid[0][0];
        int startCost = (startVal == 0) ? 0 : 1;
        int startScore = startVal;
        if(startCost<=k){
            dp[0][0][startCost] = startScore;
        }
        else{
            return -1;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int c = 0;c <= k;c++){
                    if(dp[i][j][c] == -1) continue;
                    int[][] directions = {{0,1},{1,0}};
                    for(int[] d : directions){
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if(ni < m && nj < n){
                            int nextVal = grid[ni][nj];
                            int nextCost = (nextVal == 0) ? 0 : 1;
                            int nextScore = nextVal;

                            if (c + nextCost <= k) {
                                dp[ni][nj][c + nextCost] = Math.max(
                                    dp[ni][nj][c + nextCost], 
                                    dp[i][j][c] + nextScore
                                );
                            }
                        }
                    }
                }
            }
        }
        int maxScore = -1;
        for(int c= 0; c<=k;c++){
            maxScore = Math.max(maxScore, dp[m-1][n-1][c]);
        }
        return maxScore;
    }
}
class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;
        long[][] maxDP = new long[m][n];
        long[][] minDP = new long[m][n];

        maxDP[0][0] = minDP[0][0] = grid[0][0];
        for(int i=1;i<m;i++){
            maxDP[i][0] = minDP[i][0] = maxDP[i-1][0] * grid[i][0];
        }
        for(int j=1;j<n;j++){
            maxDP[0][j] = minDP[0][j] = maxDP[0][j-1] * grid[0][j];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                long val = grid[i][j];
                if(val >=0){
                    maxDP[i][j] = Math.max(maxDP[i-1][j],maxDP[i][j-1]) * val;
                    minDP[i][j] = Math.min(minDP[i-1][j],minDP[i][j-1]) * val;
                }
                else{
                    maxDP[i][j] = Math.min(minDP[i-1][j],minDP[i][j-1]) * val;
                    minDP[i][j] = Math.max(maxDP[i-1][j], maxDP[i][j-1]) * val;
                }
            }
        }

        long result = maxDP[m-1][n-1];
        if (result < 0) {
            return -1;
        }

        return (int) (result % MOD);
    }
}
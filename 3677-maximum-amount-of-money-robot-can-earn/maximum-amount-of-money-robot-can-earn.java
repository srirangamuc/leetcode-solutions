class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        long[][][] dp = new long[m][n][3];
        for(int i=0;i<m;i++){
            for(int j=0 ; j<n;j++){
                for(int k=0;k<3;k++){
                    dp[i][j][k] = Long.MIN_VALUE / 2;
                }
            }
        }
        dp[0][0][0] = coins[0][0];
        if(coins[0][0] < 0){
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
        }
        else{
            dp[0][0][1] = coins[0][0];
            dp[0][0][2] = coins[0][0];
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j == 0) continue;
                for(int k = 0;k < 3;k++){
                    long prev = Long.MIN_VALUE / 2;
                    if(i > 0) prev = Math.max(prev,dp[i-1][j][k]);
                    if(j > 0) prev = Math.max(prev,dp[i][j-1][k]);

                    if(prev != Long.MIN_VALUE/2){
                        dp[i][j][k] = prev + coins[i][j];
                    }

                    if(k > 0 && coins[i][j] < 0){
                        long prevNeutral = Long.MIN_VALUE / 2;
                        if(i > 0) prevNeutral = Math.max(prevNeutral, dp[i-1][j][k-1]);
                        if(j > 0) prevNeutral = Math.max(prevNeutral, dp[i][j-1][k-1]);
                        if(prevNeutral != Long.MIN_VALUE / 2){
                            dp[i][j][k] = Math.max(dp[i][j][k],prevNeutral);
                        }
                    }
                }
            }
        }
        long result = Math.max(dp[m - 1][n - 1][0], 
                      Math.max(dp[m - 1][n - 1][1], dp[m - 1][n - 1][2]));
        
        return (int) result;
    }
}
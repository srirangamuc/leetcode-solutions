class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b) -> Integer.compare(a[0],b[0]));
        int n = robot.size();
        int m = factory.length;

        long[][] dp = new long[m+1][n+1];
        long INF = (long)1e15;
        for(long[] row: dp) Arrays.fill(row, INF);
        for(int i=0;i<=m ;i++){
            dp[i][0] = 0;
        }
        for(int i = 1 ; i<=m ; i++){
            int factoryPos = factory[i-1][0];
            int factoryLimit = factory[i-1][1];
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                long currentDistSum = 0;
                for(int  k =1; k <= Math.min(j, factoryLimit);k++){
                    currentDistSum += Math.abs((long) robot.get(j - k) - factoryPos);
                    if(dp[i-1][j-k] != INF){
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][j-k] + currentDistSum);
                    }
                }
            }
        }
        return dp[m][n];
    }
}
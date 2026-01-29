class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final long INF = (long) 1e18;
        int N = 26;

        long[][] dist = new long[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                dist[i][j] = (i == j) ? 0 : INF;
            }
        }   
        for(int i=0;i<original.length;i++){
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v],cost[i]);
        }

        for(int k = 0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        long ans = 0;
        for(int i=0;i<source.length();i++){
            int u = source.charAt(i) - 'a';
            int v = target.charAt(i) - 'a';
            if(dist[u][v] >= INF) return -1;
            ans += dist[u][v];
        }

        return ans;
    }
}
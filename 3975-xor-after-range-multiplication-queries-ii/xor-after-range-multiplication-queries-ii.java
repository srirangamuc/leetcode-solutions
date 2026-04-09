class Solution {
    static final int MOD = 1_000_000_007;
    private long power(long base, long exp){
        long res = 1;
        base %= MOD;
        while(exp > 0){
            if(exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n);
        long[] multipliers = new long[n];
        Arrays.fill(multipliers, 1L);
        List<int[]>[] smallKQueries = new List[B+1];
        for(int[] q : queries){
            int l = q[0] , r = q[1], k = q[2] , v = q[3];
            if(k > B){
                for(int i=l; i<=r ;i+=k){
                    multipliers[i] = (multipliers[i] * v) % MOD;
                }
            }else{
                if(smallKQueries[k] == null){
                    smallKQueries[k] = new ArrayList<>();
                }
                smallKQueries[k].add(new int[]{l,r,v});
            }
        }

        for(int k=1;k<=B;k++){
            if(smallKQueries[k] == null) continue;
            long[] diff = new long[n+k-1];
            Arrays.fill(diff,1L);
            for(int[] q: smallKQueries[k]){
                int l = q[0], r = q[1] ,  v = q[2];
                int steps = (r - l) / k;
                int lastIdx = l + steps * k;

                long invV = power(v, MOD - 2);
                diff[l] = (diff[l] * v) % MOD;
                if(lastIdx + k < diff.length){
                    diff[lastIdx + k] = (diff[lastIdx + k] * invV) % MOD;
                }
            }

            for(int i = 0;i < n ;i++){
                if(i >= k){
                    diff[i] = (diff[i] * diff[i-k]) % MOD;
                }
                multipliers[i] = (multipliers[i] * diff[i]) % MOD;
            }
        }
        long xorSum = 0;
        for(int  i =0; i < n;i++){
            long finalVal = ((long) nums[i] * multipliers[i]) % MOD;
            xorSum ^= finalVal;
        }
        return (int) xorSum;
    }
}
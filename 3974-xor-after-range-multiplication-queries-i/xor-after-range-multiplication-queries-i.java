class Solution {
    static final int MOD = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for(int[] query: queries){
            int li = query[0];
            int ri = query[1];
            int ki = query[2];
            int vi = query[3];

            for(int idx = li;idx <= ri;idx+=ki){
                long newVal = ((long) nums[idx] * vi) % MOD;
                nums[idx] = (int) newVal;
            }
        }
        int res = 0;
        for(int num:nums){
            res ^= num;
        }
        return res;
    }
}
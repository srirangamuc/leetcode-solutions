class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        long MOD = 1_000_000_007;
        // dp[i][j][0] = number of stable arrays with i zeros, j ones, ending in 0
        // dp[i][j][1] = number of stable arrays with i zeros, j ones, ending in 1
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases: filling arrays with only one type of digit up to the limit
        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {
                // To end in 0, we can append a 0 to any stable array ending in 0 or 1
                // then subtract cases that exceed the limit
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit) {
                    // Subtract the case where we had i - limit - 1 zeros and j ones, 
                    // ended in a 1, and then appended (limit + 1) zeros.
                    long invalid = dp[i - limit - 1][j][1];
                    dp[i][j][0] = (dp[i][j][0] - invalid + MOD) % MOD;
                } else if (i == limit + 1) {
                    // Special case: subtracting the sequence of all zeros (000...0)
                    dp[i][j][0] = (dp[i][j][0] - 1 + MOD) % MOD;
                }

                // To end in 1, we do the same logic mirrored
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit) {
                    long invalid = dp[i][j - limit - 1][0];
                    dp[i][j][1] = (dp[i][j][1] - invalid + MOD) % MOD;
                } else if (j == limit + 1) {
                    dp[i][j][1] = (dp[i][j][1] - 1 + MOD) % MOD;
                }
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}
class Solution {
    public int coinChange(int[] coins, int amount) {
        // 1. Initialize the DP table with amount + 1 
        // (which is effectively "Infinity" since you can't have more coins than the amount itself)
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // 2. Base case: 0 coins are needed to make the amount 0
        dp[0] = 0;

        // 3. Iterate through each coin
        for (int coin : coins) {
            // 4. Update the DP table for all amounts from 'coin' to 'amount'
            for (int i = coin; i <= amount; i++) {
                // The transition: compare current min with (1 + min coins for the remainder)
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // 5. If dp[amount] is still 'max', it means the amount is unreachable
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
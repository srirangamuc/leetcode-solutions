class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int n : nums) totalSum += n;
        if(Math.abs(target) > totalSum || (totalSum + target) % 2 != 0){
            return 0;
        }
        int subsetTarget = (totalSum + target) / 2;
        return countSubsets(nums, subsetTarget);
    }
    private int countSubsets(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int num: nums){
            for(int i=target;i >= num; i--){
                dp[i] += dp[i-num];
            }
        }
        return dp[target];
    }
}
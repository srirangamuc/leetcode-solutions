class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        for(int s: stones) totalSum +=s;
        int target = totalSum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0]=true;
        int maxAchievableSum = 0;
        for(int stone: stones){
            for(int i= target;i >= stone;i--){
                if(dp[i-stone]){
                    dp[i] = true;
                    maxAchievableSum = Math.max(maxAchievableSum ,  i);
                }
            }
        }
        return totalSum - 2* maxAchievableSum;
    }
}
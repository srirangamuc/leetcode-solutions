class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int total_sum = 0;
        int[] res = new int[n];
        for(int num:nums){
            total_sum += num;
        }
        int left_sum = 0;
        for(int i=0;i<n;i++){
            int right_sum = total_sum - left_sum-nums[i];
            res[i] = Math.abs(left_sum - right_sum);
            left_sum += nums[i];
        }
        return res;
    }
}
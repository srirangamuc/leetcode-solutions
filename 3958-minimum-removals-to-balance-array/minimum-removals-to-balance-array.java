class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int maxBalance = 0;
        Arrays.sort(nums);
        int left = 0;
        for(int right = 0;right < n;right++){
            while((long)nums[right] > (long)k * nums[left]){
                left ++;
            }
            maxBalance = Math.max(maxBalance,right-left+1);
        }
        return n - maxBalance;
    }
}
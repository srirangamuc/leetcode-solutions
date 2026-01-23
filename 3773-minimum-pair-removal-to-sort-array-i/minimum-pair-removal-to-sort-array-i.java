class Solution {
    private boolean isNonDecreasing(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {  
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    private static int[] merge(int[] nums, int idx, int value) {
        int[] newArr = new int[nums.length - 1];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == idx) {
                newArr[k++] = value;  
                i++;            
            } else {
                newArr[k++] = nums[i];
            }
        }
        return newArr;
    }
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        while (!isNonDecreasing(nums)) {   
            int min_sum = Integer.MAX_VALUE;
            int target_idx = -1;
            for (int i = 0; i < nums.length - 1; i++) {
                int curr_sum = nums[i] + nums[i + 1];
                if (curr_sum < min_sum) {
                    min_sum = curr_sum;
                    target_idx = i;
                }
            }
            nums = merge(nums, target_idx, min_sum);
            ops++;
        }
        return ops;
    }
}

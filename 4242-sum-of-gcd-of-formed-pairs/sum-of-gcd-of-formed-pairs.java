class Solution {
    private int gcd(int a, int b){
        while(b!=0){
            int temp = b ;
            b = a%b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int maxpers = Integer.MIN_VALUE;
        int[] prefixgcd = new int[n];
        for(int i=0;i<n;i++){
            maxpers = Math.max(maxpers,nums[i]);
            prefixgcd[i] = gcd(nums[i],maxpers);
        }
        Arrays.sort(prefixgcd);
        int left = 0 ;
        int right = n-1;
        long ans = 0;
        while(left < right){
            ans += gcd(prefixgcd[left],prefixgcd[right]);
            left++;
            right--;
        }
        return ans;
    }
}
class Solution {
    private int reverseInteger(int n){
        int rev = 0;
        while(n > 0){
            rev = (rev * 10) + (n % 10);
            n /= 10;
        }
        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> lastSeenReverse = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for(int j = 0; j< nums.length;j ++){
            int currentVal = nums[j];
            if(lastSeenReverse.containsKey(currentVal)){
                int i = lastSeenReverse.get(currentVal);
                minDistance = Math.min(minDistance,j-i);
            }
            int reversedVal = reverseInteger(currentVal);
            lastSeenReverse.put(reversedVal, j);
        }
        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
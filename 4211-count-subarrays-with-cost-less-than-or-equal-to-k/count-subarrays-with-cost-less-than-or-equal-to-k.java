class Solution {
    public long countSubarrays(int[] nums, long k) {
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();

        int l = 0;
        long count = 0;
        for(int r = 0;r< nums.length;r++){
            while(!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]){
                maxD.pollLast();
            }
            maxD.addLast(r);
            while(!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]){
                minD.pollLast();
            }
            minD.addLast(r);
            while(l <= r){
                long max = nums[maxD.peekFirst()];
                long min = nums[minD.peekFirst()];
                long len = r - l + 1;
                long cost = (max - min) * len;

                if(cost <= k) break;
                if(maxD.peekFirst() == l) maxD.pollFirst();
                if(minD.peekFirst() == l) minD.pollFirst();
                l ++;
            }
            count += (r - l  + 1);
        }
        return count;
    }
}
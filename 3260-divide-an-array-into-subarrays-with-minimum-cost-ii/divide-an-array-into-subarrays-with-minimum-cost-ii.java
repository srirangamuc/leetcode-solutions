import java.util.*;

class Solution {
    private TreeSet<Integer> left = new TreeSet<>((a, b) -> a.equals(b) ? 0 : (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b)));
    private TreeSet<Integer> right = new TreeSet<>((a, b) -> a.equals(b) ? 0 : (nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : Integer.compare(a, b)));
    private static int[] nums;
    private long currentSum = 0;

    public long minimumCost(int[] nums, int k, int dist) {
        Solution.nums = nums;
        int n = nums.length;
        int m = k - 1;
        for (int i = 1; i <= dist + 1; i++) {
            add(i, m);
        }
        
        long minSum = currentSum;
        for (int i = dist + 2; i < n; i++) {
            remove(i - dist - 1, m);
            add(i, m);
            minSum = Math.min(minSum, currentSum);
        }
        
        return nums[0] + minSum;
    }

    private void add(int idx, int m) {
        left.add(idx);
        currentSum += nums[idx];
        if (left.size() > m) {
            int last = left.pollLast();
            currentSum -= nums[last];
            right.add(last);
        }
    }

    private void remove(int idx, int m) {
        if (left.contains(idx)) {
            left.remove(idx);
            currentSum -= nums[idx];
            if (!right.isEmpty()) {
                int first = right.pollFirst();
                currentSum += nums[first];
                left.add(first);
            }
        } else {
            right.remove(idx);
        }
    }
}
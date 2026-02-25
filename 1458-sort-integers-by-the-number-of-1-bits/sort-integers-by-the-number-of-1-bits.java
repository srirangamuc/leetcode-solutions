import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB) return a - b; 
            return countA - countB; 
        });
        for (int num : arr) {
            pq.add(num);
        }
        int[] result = new int[arr.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
        return result;
    }
}

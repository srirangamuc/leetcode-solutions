class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );
        for(Map.Entry<Integer, Integer> entry :  freqMap.entrySet()){
            heap.offer(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }
        int[] result = new int[k];
        for(int i=k-1;i >=0 ;i--){
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}
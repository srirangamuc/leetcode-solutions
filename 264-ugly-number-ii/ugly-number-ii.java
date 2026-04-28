class Solution {
    public int nthUglyNumber(int n) {
        if(n ==1) return 1;
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int[] factors = {2,3,5};
        heap.add(1L);
        seen.add(1L);
        long currentUgly = 1;
        for(int i=0;i<n;i++){
            currentUgly = heap.poll();
            for(int f: factors){
                long nextUgly = currentUgly * f;
                if(!seen.contains(nextUgly)){
                    seen.add(nextUgly);
                    heap.add(nextUgly);
                }
            }
        }
        return (int) currentUgly;
    }
}
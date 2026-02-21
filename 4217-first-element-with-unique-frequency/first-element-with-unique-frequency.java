class Solution {
    public int firstUniqueFreq(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for(int n : nums){
            counts.put(n,counts.getOrDefault(n,0) + 1);
        }
        Map<Integer,Integer> freqOccurence = new HashMap<>();
        for(int freq: counts.values()){
            freqOccurence.put(freq,freqOccurence.getOrDefault(freq,0) + 1);
        }
        for(int n : nums){
            int f = counts.get(n);
            if(freqOccurence.get(f) == 1){
                return n;
            }
        }
        return -1;
    }
}
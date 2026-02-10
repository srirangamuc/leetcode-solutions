class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> evenFreq = new HashMap<>();
            Map<Integer,Integer> oddFreq = new HashMap<>();
            int disEven = 0;
            int disOdd = 0;
            for(int j=i;j<n;j++){
                int val = nums[j];
                if(val % 2 == 0){
                    evenFreq.put(val,evenFreq.getOrDefault(val,0) + 1);
                    if(evenFreq.get(val) == 1){
                        disEven ++;
                    }
                }
                else{
                    oddFreq.put(val,oddFreq.getOrDefault(val,0) + 1);
                    if(oddFreq.get(val) == 1){
                        disOdd ++;
                    }
                }
                if(disEven == disOdd){
                    maxLen = Math.max(maxLen,j-i+1);
                }
            }
        }
        return maxLen;
    }
}
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            int distinct = 0;
            HashMap<Integer,Integer> countFreq = new HashMap<>();
            int minFreq = Integer.MAX_VALUE;
            int maxFreq = 0;
            for(int j = i;j < n;j++){
                int idx = s.charAt(j) - 'a';
                int old = freq[idx];
                if(old > 0){
                    countFreq.put(old,countFreq.get(old)-1);
                    if(countFreq.get(old) == 0){
                        countFreq.remove(old);
                    }
                }
                else{
                    distinct++;
                }
                freq[idx]++;
                int now = freq[idx];
                countFreq.put(now,countFreq.getOrDefault(now,0) + 1);
                maxFreq = Math.max(maxFreq,now);
                if(countFreq.size() == 0){
                    minFreq = Collections.min(countFreq.keySet());
                }
                if(countFreq.size() == 1){
                    ans = Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
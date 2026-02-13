class Solution {
    private int longestRun(String s, char ch){
        int max = 0, curr = 0;
        for(char c: s.toCharArray()){
            if(c == ch) curr ++;
            else curr = 0;
            max = Math.max(max,curr);
        }
        return max;
    }
    private int twoChar(String s, char x, char y, char block){
        int n = s.length();
        int ans = 0;
        int diff = 0;
        int[] first = new int[2*n+1];
        int[] version = new int[2*n+1];
        int curV = 1;
        first[n] = -1;
        version[n] = curV;

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == block){
                curV ++;
                diff = 0;
                version[n] = curV;
                first[n] = i;
                continue;
            }
            if(c == x) diff++;
            else if(c == y) diff--;
            int idx = diff + n;
            if(version[idx] == curV){
                ans = Math.max(ans,i-first[idx]);
            }
            else{
                version[idx] = curV;
                first[idx] = i;
            }
        }
        return ans;
    }
    private int threeChar(String s){
        int a=0,b=0,c=0;
        int ans=0;
        Map<Long,Integer> map=new HashMap<>();
        map.put(0L,-1);
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a'){ a++; }
            else if(ch=='b'){ b++; }
            else{ c++; }
            long key=(((long)(a-b))<<32)|( (a-c)&0xffffffffL );
            Integer prev=map.get(key);
            if(prev!=null){
                ans=Math.max(ans,i-prev);
            }else{
                map.put(key,i);
            }
        }
        return ans;
    }
    public int longestBalanced(String s) {
        int ans = 0;

        // Case 1: Only one character series is going on
        ans = Math.max(ans,longestRun(s,'a'));
        ans = Math.max(ans,longestRun(s,'b'));
        ans = Math.max(ans,longestRun(s,'c'));

        // Case 2: Is two characters are distinct and foreign character appears
        ans = Math.max(ans,twoChar(s,'a','b','c'));
        ans = Math.max(ans,twoChar(s,'b','c','a'));
        ans = Math.max(ans,twoChar(s,'a','c','b'));

        // Case 3: All three characters
        ans = Math.max(ans, threeChar(s));

        return ans;
    }
}
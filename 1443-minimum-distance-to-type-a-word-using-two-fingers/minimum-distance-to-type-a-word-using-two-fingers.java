class Solution {
    private Integer[][] memo;
    private int getDist(int pos1, int pos2){
        if(pos1 == 26) return 0;
        int r1 = pos1/6, c1 = pos1 % 6;
        int r2 = pos2 / 6, c2 = pos2 % 6;
        return Math.abs(r1-r2) + Math.abs(c1-c2);
    }
    public int minimumDistance(String word) {
        int n = word.length();
        memo = new Integer[n][27];
        return solve(word,0,26);
    }
    private int solve(String word, int idx, int otherPos){
        if(idx == word.length()) return 0;
        if(memo[idx][otherPos] != null) return memo[idx][otherPos];
        int currChar = word.charAt(idx) - 'A';
        int res;
        if(idx == 0){
            //First Character is always free
            res = solve(word, idx + 1, otherPos);
        }
        else{
            int prevChar = word.charAt(idx-1) - 'A';
            //Option 1 :  Use the finger that just types word[idx-1]
            int dist1 = getDist(prevChar, currChar) + solve(word,idx+1, otherPos);
            //Option 2 : Use the other finger
            int dist2 = getDist(otherPos, currChar) + solve(word, idx + 1, prevChar);
            res = Math.min(dist1, dist2);
        }
        return memo[idx][otherPos] = res;
    }
}
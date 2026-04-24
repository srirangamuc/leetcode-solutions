class Solution {
    public int furthestDistanceFromOrigin(String moves) {
       int lcount = 0;
       int rcount = 0;
       int ucount = 0;
       for(char dir : moves.toCharArray()){
        if (dir == 'L'){
            lcount += 1;
        }
        else if(dir == 'R'){
            rcount += 1;
        }
        else{
            ucount += 1;
        }
       }
       return Math.abs(lcount - rcount) + ucount; 
    }
}
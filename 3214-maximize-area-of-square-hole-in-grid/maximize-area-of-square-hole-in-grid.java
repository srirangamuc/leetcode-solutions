class Solution {
    private int maxGap(int[] bars){
        if(bars.length == 0) return 1;
        Arrays.sort(bars);
        int maxRun = 1, currRun = 1;
        for(int i=1;i<bars.length;i++){
            if(bars[i] == bars[i-1]+1){
                currRun++;
            }
            else{
                currRun = 1;
            }
            maxRun = Math.max(maxRun,currRun);
        }
        return maxRun + 1;
    }
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxGap(hBars);
        int maxW = maxGap(vBars);
        int side = Math.min(maxH,maxW);
        return side * side;
    }
}
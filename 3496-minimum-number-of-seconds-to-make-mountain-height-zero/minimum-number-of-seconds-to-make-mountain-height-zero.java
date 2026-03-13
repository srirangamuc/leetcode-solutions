class Solution {
    private boolean canBreak(int mountainHeight,int[] workerTimes,long timeLimit){
        long total_reduced = 0;
        for(int w: workerTimes){
            double val = (2.0 * timeLimit) / w;
            long x = (long) ((-1.0 + Math.sqrt(1.0 + 4.0 * val))/2.0);
            total_reduced +=x;
            if(total_reduced >= mountainHeight){
                return true;
            }
        }
        return total_reduced >= mountainHeight;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long low = 0;
        long min_time = Long.MAX_VALUE;
        for(int w : workerTimes){
            min_time = Math.min(min_time,(long)w);
        }
        long high = min_time * mountainHeight * (mountainHeight + 1L)/2L;
        long result = high;
        while(low <= high){
            long mid = low + (high-low)/2;
            if(canBreak(mountainHeight,workerTimes,mid)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return result;
    }
}
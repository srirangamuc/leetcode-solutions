class Solution {
    public double separateSquares(int[][] squares) {
        int n = squares.length;
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double totalArea = 0;

        for(int[] s: squares){
            double y = s[1];
            double l = s[2];
            low = Math.min(low,y);
            high = Math.max(high,y+l);
            totalArea += l*l;
        }

        double half = totalArea/2.0;
        for(int it=0;it<60;it++){
            double mid = (low+high)/2.0;
            double areaBelow = 0.0;
            for(int[] s : squares){
                double bottom = s[1];
                double top = s[1] + s[2];
                double l = s[2];
                if(mid <= bottom){
                    continue;
                }
                else if(mid >= top){
                    areaBelow += l*l;
                }
                else{
                    areaBelow += l*(mid-bottom);
                }
            }
            if(areaBelow < half){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for(int i=0;i<1024;i++){
            if(Integer.bitCount(i) == turnedOn){
                int hours = i >> 6;
                int mins = i & 0x3F;
                if(hours < 12 && mins < 60){
                    res.add(hours + ":" + (mins < 10 ? "0"+mins : mins ));
                }
            }
        }
        return res;
    }
}
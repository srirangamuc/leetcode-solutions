class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if(encodedText.isEmpty()) return "";
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<cols;j++){
            for(int i=0;i<rows;i++){
                int r = i;
                int c = j + i;
                if(c < cols){
                    int index = r * cols + c;
                    sb.append(encodedText.charAt(index));
                }
                else{
                    break;
                }
            }
        }
        int last = sb.length() - 1;
        while(last >= 0 && sb.charAt(last) == ' '){
            last --;
        }
        sb.setLength(last+1);
        return sb.toString();
    }
}
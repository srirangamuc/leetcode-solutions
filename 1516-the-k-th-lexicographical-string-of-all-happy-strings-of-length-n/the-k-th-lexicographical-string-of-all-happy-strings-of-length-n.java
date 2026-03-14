class Solution {
    private char[] getNextChoices(char lastChar) {
        if (lastChar == 'a') return new char[]{'b', 'c'};
        if (lastChar == 'b') return new char[]{'a', 'c'};
        return new char[]{'a', 'b'}; // lastChar == 'c'
    }
    public String getHappyString(int n, int k) {
        StringBuilder result = new StringBuilder();
        int totalHappy = 3 * (int) Math.pow(2,n-1);
        if(k > totalHappy) return "";
        char[] choices = {'a','b','c'};
        k -- ;
        int partitionSize = (int) Math.pow(2, n - 1);
        int firstCharIdx = k / partitionSize;
        result.append(choices[firstCharIdx]);
        k %= partitionSize;

        for (int i = 0; i < n - 1; i++) {
            partitionSize /= 2;
            char lastChar = result.charAt(result.length() - 1);
            char[] nextChoices = getNextChoices(lastChar);
            
            int charIdx = k / partitionSize;
            result.append(nextChoices[charIdx]);
            
            k %= partitionSize;
        }

        return result.toString();
    }
}
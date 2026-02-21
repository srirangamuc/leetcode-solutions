class Solution {
    private boolean isPrime(int n){
        return (n == 2 || n == 3 || n == 5 || n == 7 || 
                n == 11 || n == 13 || n == 17 || n == 19 || 
                n == 23 || n == 29 || n == 31);
    }
    public int countPrimeSetBits(int left, int right) {
        int res = 0;
        for(int i = left; i <= right;i++){
            int bits = Integer.bitCount(i);
            if(isPrime(bits)) res ++;
        }
        return res;
    }
}
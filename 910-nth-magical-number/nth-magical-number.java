class Solution {
    private long gcd(long a,long b){
        while(b!=0){
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private long lcm (long a,long b){
        return (a/gcd(a,b)) *b;
    }
    public int nthMagicalNumber(int n, int a, int b) {
        long mod = 1_000_000_007L;
        long lcm = lcm(a,b);
        long left = Math.min(a,b);
        long right = (long) n * Math.min(a,b);
        while(left < right){
            long mid = left + (right - left) / 2;
            long count = mid / a + mid / b - mid / lcm;
            if(count < n) left = mid+1;
            else right = mid;
        }
        return (int)(left % mod);
    }
}
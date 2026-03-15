class Fancy {
    private List<Long> arr;
    private long a = 1;
    private long b = 0;
    private static final int MOD = 1_000_000_007;
    private long power(long base, long exp){
        long res = 1;
        base %= MOD;
        while(exp > 0){
            if(exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
    public Fancy() {
        arr = new ArrayList<>();
    }
    
    public void append(int val) {
        long invA = power(a,MOD-2);
        long baseValue = (((val - b + MOD) % MOD) * invA) % MOD;
        arr.add(baseValue);
    }
    
    public void addAll(int inc) {
        b  = (b + inc) % MOD;
    }
    
    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= arr.size()) return -1;
        long result = (arr.get(idx) * a + b) % MOD;
        return (int) result;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
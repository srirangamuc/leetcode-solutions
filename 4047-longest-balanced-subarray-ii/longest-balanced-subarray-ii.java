class Solution {
    private int[] min, max, lazy;
    private void push(int v) {
        if(lazy[v] != 0){
            apply(2*v,lazy[v]);
            apply(2*v+1,lazy[v]);
            lazy[v] = 0;
        }
    }
    private void apply(int v, int val){
        min[v] += val;
        max[v] += val;
        lazy[v] += val;
    }
    private void update(int v, int tl, int tr, int l, int r, int add){
        if(l > r) return;
        if(l == tl && r == tr){
            apply(v,add);
        }else{
            push(v);
            int tm = (tl + tr) / 2;
            update(2*v, tl, tm, l, Math.min(r,tm),add);
            update(2*v+1, tm+1,tr,Math.max(l,tm+1),r,add);
            min[v] = Math.min(min[2*v],min[2*v+1]);
            max[v] = Math.max(max[2*v],max[2*v+1]);
        }
    }
    private int findFirstZero(int v, int tl, int tr, int l, int r){
        if (l > r || min[v] > 0 || max[v] < 0) return -1;
        if(tl == tr) return tl;
        push(v);
        int tm = (tl + tr) / 2;
        int res = findFirstZero(2*v,tl, tm, l, Math.min(r,tm));
        if(res == -1){
            res = findFirstZero(2*v + 1, tm + 1,tr, Math.max(l,tm+1),r);
        }
        return res;
    }
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        min = new int[4 * n];
        max = new int[4 * n];
        lazy = new int[4 * n];
        Map<Integer,Integer> lastSeen = new HashMap<>();
        int maxLen = 0;
        for(int r = 0;r < n; r++){
            int val = nums[r];
            int prevIdx = lastSeen.getOrDefault(val,-1);

            // Update the range [prevIdx + 1, r]
            // If even add 1 else add -1
            int delta = (val % 2 == 0 ? 1 : -1);
            update(1,0,n-1,prevIdx+1, r, delta);

            lastSeen.put(val, r);

            //Find the leftmost L in [0,r] where balance is 0
            int leftMostL = findFirstZero(1,0,n-1,0,r);
            if(leftMostL != -1){
                maxLen = Math.max(maxLen,r-leftMostL+1);
            }
        }
        return maxLen;
    }
}
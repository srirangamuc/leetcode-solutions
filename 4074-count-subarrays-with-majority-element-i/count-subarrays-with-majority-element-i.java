class Solution {
    private int[] tree;
    private int offset;
    private int query(int node,int start, int end, int left, int right){
        if(right < start || left > end) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = start + (end-start)/ 2;
        return query(2*node,start, mid, left, right) + query(2*node+1, mid+1, end, left, right);
    }
    private void update(int node, int start, int end, int idx, int val){
        if(start == end){
            tree[node] += val;
            return;
        }
        int mid = start + (end-start) / 2;
        if(idx <= mid) update(2*node,start, mid, idx, val);
        else update(2*node+1, mid+1, end, idx, val);
        tree[node] = tree[2*node] + tree[2*node+1];
    }
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        offset = n;
        tree = new int[4* (2*n + 1)];

        int count = 0;
        int currentPrefixSum = 0;
        update(1,0,2*n,offset,1);
        for(int num:nums){
            currentPrefixSum += (num == target ? 1 : -1);
            count += query(1,0,2*n,0,currentPrefixSum + offset - 1);
            update(1,0,2*n,currentPrefixSum + offset,1);
        }
        return count;
    }
}
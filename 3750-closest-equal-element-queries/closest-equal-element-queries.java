class Solution {
    private int getDist(int i, int j, int n){
        int directDist = Math.abs(i-j);
        return Math.min(directDist,n-directDist);
    }
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int qLen = queries.length;
        List<Integer> answer = new ArrayList<>(qLen);
        Map<Integer, List<Integer>> valToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] idxToPos = new int[n];
        for (List<Integer> indices : valToIndices.values()) {
            for (int pos = 0; pos < indices.size(); pos++) {
                idxToPos[indices.get(pos)] = pos;
            }
        }

        for (int i = 0; i < qLen; i++) {
            int qIdx = queries[i];
            int val = nums[qIdx];
            List<Integer> indices = valToIndices.get(val);

            if (indices.size() <= 1) {
                answer.add(-1);
                continue;
            }

            int currentPos = idxToPos[qIdx];
            int m = indices.size();

            int leftIdx = indices.get((currentPos - 1 + m) % m);
            int rightIdx = indices.get((currentPos + 1) % m);

            int minDistance = Math.min(getDist(qIdx, leftIdx, n), getDist(qIdx, rightIdx, n));
            answer.add(minDistance);
        }

        return answer;
    }
}
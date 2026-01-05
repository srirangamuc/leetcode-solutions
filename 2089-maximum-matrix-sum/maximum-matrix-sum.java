class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sumAbs = 0;
        int negCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) negCount++;
                int abs = Math.abs(val);
                sumAbs += abs;
                minAbs = Math.min(minAbs, abs);
            }
        }

        if (negCount % 2 == 0) {
            return sumAbs;
        } else {
            return sumAbs - 2L * minAbs;
        }
    }
}
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0;
        int right = n-1;

        int r = n-1;
        while (colors[0] == colors[r]) {
            r--;
        }
        int dist1 = r;

        int l = 0;
        while (colors[n - 1] == colors[l]) {
            l++;
        }
        int dist2 = (n - 1) - l;

        return Math.max(dist1, dist2);
    }
}
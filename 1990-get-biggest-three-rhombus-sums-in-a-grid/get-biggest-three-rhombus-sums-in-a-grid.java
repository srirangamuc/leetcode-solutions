class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // Using TreeSet to keep elements unique and sorted
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        // Pre-calculating diagonal prefix sums
        // diag1: \ (top-left to bottom-right)
        // diag2: / (top-right to bottom-left)
        int[][] diag1 = new int[m + 1][n + 2];
        int[][] diag2 = new int[m + 1][n + 2];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diag1[i + 1][j + 1] = diag1[i][j] + grid[i][j];
                diag2[i + 1][j + 1] = diag2[i][j + 2] + grid[i][j];
                set.add(grid[i][j]); // Every single cell is a radius 0 rhombus
            }
        }

        // Iterate through each cell as the TOP vertex of a rhombus
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // L is the distance from the top vertex to the side vertices
                for (int L = 1; i + 2 * L < m && j - L >= 0 && j + L < n; L++) {
                    int topR = i, topC = j;
                    int rightR = i + L, rightC = j + L;
                    int bottomR = i + 2 * L, bottomC = j;
                    int leftR = i + L, leftC = j - L;

                    // Calculate the 4 segments using prefix sums
                    // Segment 1: Top to Right ( \ )
                    int s1 = diag1[rightR + 1][rightC + 1] - diag1[topR][topC];
                    // Segment 2: Right to Bottom ( / )
                    int s2 = diag2[bottomR + 1][bottomC + 1] - diag2[rightR][rightC + 2];
                    // Segment 3: Bottom to Left ( \ )
                    int s3 = diag1[bottomR + 1][bottomC + 1] - diag1[leftR][leftC];
                    // Segment 4: Left to Top ( / )
                    int s4 = diag2[leftR + 1][leftC + 1] - diag2[topR][topC + 2];

                    // Sum them up and subtract the 4 corners (they were added twice)
                    int total = s1 + s2 + s3 + s4 - grid[topR][topC] - grid[rightR][rightC] - grid[bottomR][bottomC] - grid[leftR][leftC];
                    set.add(total);
                }
            }
        }

        // Extract the top 3
        int count = Math.min(set.size(), 3);
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = set.pollFirst();
        }
        
        return result;
    }
}
class Solution {
    private int lcs(String s,String t){
        int n = s.length();
        int m = t.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {
                if (s.charAt(ind1 - 1) == t.charAt(ind2 - 1))
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                else
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
            }
        }

        return dp[n][m];
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        return lcs(s,rev);
    }
}
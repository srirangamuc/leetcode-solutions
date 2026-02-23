class Solution {
    public boolean hasAllCodes(String s, int k) {
        int required = 1 << k; 
        int n = s.length();
        Set<String> st = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            st.add(s.substring(i, i + k));
            if (st.size() == required) {
                return true;
            }
        }
        return false;
    }
}
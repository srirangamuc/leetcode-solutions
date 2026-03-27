class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n =mat[0].length;
        int shift = k % n;
        if(shift == 0) return true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] != mat[i][(j+shift)%n]){
                    return false;
                }
            }
        }
        return true;
    }
}
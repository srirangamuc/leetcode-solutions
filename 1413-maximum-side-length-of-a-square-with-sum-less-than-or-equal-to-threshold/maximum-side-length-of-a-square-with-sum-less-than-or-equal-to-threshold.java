class Solution {
    private boolean existsSquare(int[][] prefix,int rows,int cols,int k,int threshold){
        for(int i=0;i+k <=rows;i++){
            for(int j=0;j + k <=cols;j++){
                int sum = prefix[i + k][j + k]
                    - prefix[i][j + k]
                    - prefix[i + k][j]
                    + prefix[i][j];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] prefix = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                prefix[i][j] = mat[i-1][j-1]+
                                prefix[i-1][j]+
                                prefix[i][j-1]
                                - prefix[i-1][j-1];
            }
        }

        int left = 0, right = Math.min(m,n);
        int ans = 0;
        while(left <= right){
            int mid = (right + left) / 2;
            if(existsSquare(prefix,n,m,mid,threshold)){
                ans = mid;
                left = mid+1;
            } 
            else{
                right = mid-1;
            }
        }
        return ans;
    }
}
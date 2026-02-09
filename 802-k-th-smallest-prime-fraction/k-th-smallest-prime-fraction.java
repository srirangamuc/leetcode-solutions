class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        double left = 0.0, right = 1.0;
        while(true){
            double mid = (left+right)/2;
            int count = 0;
            int num = 0,den = 1;
            int i = 0;
            for(int j=0;j<n;j++){
                while(i < j && arr[i] <= mid * arr[j]){
                    i++;
                }
                count += i;

                if(i > 0){
                    int a = arr[i-1];
                    int b = arr[j];
                    if(a*den > num * b){
                        num = a;
                        den = b;
                    }
                }
            } 
            if(count == k){
                return new int[]{num,den};
            }else if(count < k){
                left = mid;
            }
            else{
                right = mid;
            }
        }
    }
}
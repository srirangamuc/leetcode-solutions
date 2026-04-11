class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for(int i=0;i<nums.length;i++){
            int num = nums[i];
            if(!map.containsKey(num)){
                map.put(num,new int[]{-1,i});
            }
            else{
                int[] indices = map.get(num);
                if(indices[0] != -1){
                    int currentDist = 2 * (i - indices[0]);
                    minDistance = Math.min(minDistance, currentDist);
                    found = true;
                }
                indices[0] = indices[1];
                indices[1] = i;
            }
        } 
        return found ? minDistance : -1;
    }
}
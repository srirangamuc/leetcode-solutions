class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hset = new HashSet<>();
        for(int num:nums){
            if(hset.contains(num)){
                return true;
            }
            else{
                hset.add(num);
            }
        }
        return false;
    }
}
class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        for(int num:nums){
            stack.addLast((long)num);
            while(stack.size() >= 2){
                long last = (long)stack.removeLast();
                long secondLast = (long)stack.removeLast();
                if(last == secondLast){
                    stack.addLast((long)last+secondLast);
                }
                else{
                    stack.addLast((long)secondLast);
                    stack.addLast((long)last);
                    break;
                }
            }
        }
        List<Long> res = new ArrayList<>();
        for(long val:stack){
            res.add(val);
        }
        return res;

    }
}
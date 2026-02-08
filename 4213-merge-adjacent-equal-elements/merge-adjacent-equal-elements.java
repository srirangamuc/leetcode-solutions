class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        Deque<Long> stack = new ArrayDeque<>();
        for(int num:nums){
            stack.addLast((long)num);
            while (stack.size() >= 2) {
                long last = stack.removeLast();
                long secondLast = stack.peekLast();

                if (last == secondLast) {
                    stack.removeLast();
                    stack.addLast(last + secondLast);
                } else {
                    stack.addLast(last);
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
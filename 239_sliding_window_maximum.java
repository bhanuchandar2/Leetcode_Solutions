class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int result[]=new int[nums.length-k+1];
        int res=0;
        Deque<Integer> dq = new ArrayDeque<>();
        int l=0;
        for(int i=0; i<nums.length; i++){

            while(!dq.isEmpty() && dq.peekFirst()<l){
                    dq.removeFirst();
            }
            
            while(!dq.isEmpty() && nums[i]>nums[dq.peekLast()]){
                dq.removeLast();
            }
            dq.addLast(i);

            if(i-l+1==k){
                result[res++]=nums[dq.peekFirst()];
                l++;
            }
        }
        return result;
    }
}
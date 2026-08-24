class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<2*n;i++){
            int curr=i%n;
            while(!s.isEmpty() &&  nums[curr] > nums[s.peek()]){
                int index = s.pop();
                res[index] = nums[curr];
            }


        
            if(i<n){
                s.push(curr);
            }

        }
        while (!s.isEmpty()) {
            res[s.pop()] = -1;
        }
        return res;
    }
}
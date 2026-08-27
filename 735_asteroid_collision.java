class Solution {
    public int[] asteroidCollision(int[] nums) {
         Stack<Integer> s = new Stack<>();
        for(int i=0; i<nums.length; i++){
            boolean pushNums=true;
            while(!s.isEmpty() && nums[i]<0 && s.peek()>0){
                if(Math.abs(nums[i])  > Math.abs(s.peek())){
                    s.pop();

                }
                else if(Math.abs(nums[i])  == Math.abs(s.peek())){
                    s.pop();
                    pushNums=false;
                    break;
                }
                else{
                    pushNums=false;
                    break;
                }
            }
            if(pushNums){
                s.push(nums[i]);
            }
        }
        int arr[] = new int[s.size()];
        int curr=arr.length-1;
        while(!s.isEmpty()){
            int value=s.pop();
            arr[curr]=value;
            curr-=1;
        }
        return arr;
    }
}
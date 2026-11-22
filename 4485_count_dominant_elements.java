class Solution {
    public int countDominantElements(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        int count=0;
        for(int i=0; i<nums.length; i++){
            if(i==0){
                if(nums[i]>=nums[i+1]){
                    count+=1;
                }
            }
            else if(i==nums.length-1){
                if(nums[i]>=nums[i-1]){
                    count+=1;
                }   
            }
            else {
                if(nums[i] >= (nums[i-1] + nums[i+1]) / 2.0) {
                    count++;
                }
                }
        }
        return count;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int left=0;
        int right=nums.length-1;
        int sum=0;
        int max=0;
        int target=0;
        for(int s=0; s<nums.length;s++){
            target+=nums[s];
        }
        target=target-x;

        if (target < 0) {
            return -1;
        }

        for(int r=0;  r<nums.length; r++){
            sum+=nums[r];
             while(sum>target){
                sum-=nums[left];
                left++;
             }

             if(sum==target){
                max=Math.max(max,r-left+1);
             }
        }
        if (max == 0) {
            return target == 0 ? nums.length : -1;
        }

        return nums.length - max;
    }
}
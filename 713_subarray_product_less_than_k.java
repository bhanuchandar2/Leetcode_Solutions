class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int l=0;
        int r=0;
        int prod=1;
        int count=0;
        while(r<nums.length){
            
            prod*=nums[r];
            while(prod>=k){
                prod=prod/nums[l];
                l++;
            }
                count+=r-l+1;
            
            
            r++;
        }
        return count;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int maxProd=nums[0];
        int CurrMax=nums[0];
        int CurrMin=nums[0];
        for(int i=1;i<nums.length;i++){
            int oldMax=CurrMax;
            int oldMin=CurrMin;
            CurrMax=Math.max(nums[i],Math.max(nums[i]*oldMax,nums[i]*oldMin));
            CurrMin=Math.min(nums[i],Math.min(nums[i]*oldMax,nums[i]*oldMin));
            maxProd=Math.max(CurrMax,maxProd);
        }
        return maxProd;
    }
}
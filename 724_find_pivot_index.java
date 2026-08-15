class Solution {
    public int pivotIndex(int[] nums) {
        int left_sum[]=new int[nums.length];
        int right_sum[]=new int[nums.length];
        left_sum[0]=nums[0];
        right_sum[nums.length-1]=nums[nums.length-1];
        for(int i=1;i<nums.length;i++){
            left_sum[i]=nums[i]+left_sum[i-1];
        }

        for(int i=nums.length-2;i>=0;i--){
            right_sum[i]=nums[i]+right_sum[i+1];
        }
        int i=0;
        while(i<nums.length){
            if(left_sum[i]==right_sum[i]){
                return i;
            }
            i++;
        }
        return -1;
    }
}
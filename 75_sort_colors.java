class Solution {
    public void sortColors(int[] nums) {
        int left=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==2){
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
            else if(nums[mid]==0){
                int temp=nums[mid];
                nums[mid]=nums[left];
                nums[left]=temp;
                left++;
                mid++;
            }
            else{
                mid++;
            }
        }
    }
}
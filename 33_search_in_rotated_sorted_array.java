class Solution {
    public int search(int[] nums, int target) {
        int pivot=findpivot(nums);
        if(pivot==-1){
            return BinarySearch(target,nums,0,nums.length-1);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        else if(target>=nums[0]){
            return BinarySearch(target,nums,0,pivot-1);
        }
        else{
            return BinarySearch(target,nums,pivot+1,nums.length-1);
        }
    }
    public int findpivot(int nums[]){
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int mid=s+(e-s)/2;
            if(mid<e && nums[mid]>nums[mid+1]){
                return mid;
            }
            if(mid>s && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[s]>=nums[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }

    public int BinarySearch(int target,int nums[],int s,int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }
}
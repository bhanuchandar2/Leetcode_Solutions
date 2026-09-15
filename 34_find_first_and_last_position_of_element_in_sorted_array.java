class Solution {

     public int[] searchRange(int[] nums, int target) {
        int lm=LeftMost(target,nums);
        int rm=RightMost(target,nums);
        int ans[]={lm,rm};
        return ans;
    }
    public static int LeftMost(int target,int arr[]){
        int start=0;
        int end=arr.length-1;
          int ans=-1;
          while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

          }
          return ans;
     }

     public static int RightMost(int target,int[] arr){
         int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                ans=mid;
                start=mid+1;
            }
            else if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    
}
}
class Solution {
    public int firstStableIndex(int[] arr, int k) {
       
       int minsuffix[]=new int[arr.length];
       int min=Integer.MAX_VALUE;
       for(int i=arr.length-1;i>=0;i--){
         if(arr[i]<min){
            min=arr[i];
         }
         minsuffix[i]=min;
       }
       int max=Integer.MIN_VALUE;
       for(int i=0;i<arr.length;i++){
         if(arr[i]>max){
            max=arr[i];
         }
         if(max-minsuffix[i]<=k){
            
               return i;
            
         }
       }
       
       return -1;
    }
}
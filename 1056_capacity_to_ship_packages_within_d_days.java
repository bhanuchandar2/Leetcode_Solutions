class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE;
        long end=0;
      for(int i = 0; i < weights.length; i++){

            if(weights[i] > max){
                max = weights[i];
            }

            end += weights[i];
        }
      long start=max;
    
      while(start<=end){
         int k=days;
         long mid=start+(end-start)/2;
         long sum=0;
         for(int i=0;i<weights.length;i++){
            if(sum+weights[i]<=mid){
               sum+=weights[i];
            }
            else{
               k-=1;
               sum=weights[i];
              
            }
         }

         if(k>0){
            end=mid-1;
         }
         else{
            start=mid+1;
         }
         
      }
      return (int)start;
    }
}
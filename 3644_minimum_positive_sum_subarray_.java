class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int prefsum[]=new int[nums.size()];
        int currsum=0;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.size(); i++){
            currsum+=nums.get(i);
            prefsum[i]=currsum;
        }
        for(int i=0; i<prefsum.length; i++){
           for(int j=0; j<=i; j++){
            int len=i-j+1;
                if(len>=l && len<=r){
                    int sum=prefsum[i]-(j>0?prefsum[j-1]:0);
                    if(sum>0){
                        min=Math.min(sum,min);
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
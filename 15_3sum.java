class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr=i;
            int left=i+1;
            int right=nums.length-1;
            
            while(left<right){
                List<Integer> list = new ArrayList<>();
                int ans=nums[curr]+nums[left]+nums[right];
                if(ans==0){
                   
                    list.add(nums[curr]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    
                    result.add(list);
                   int leftValue = nums[left];
                   int rightValue = nums[right];

                    while (left < right && nums[left] == leftValue) {
                            left++;
                    }

                    while (left < right && nums[right] == rightValue) {
                            right--;
                    }
                }
                else if(ans<0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}
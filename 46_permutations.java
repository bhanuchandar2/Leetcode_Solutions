class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean used[]=new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        backtrack(used,current,nums,result);
        return result;
    }

    public static void backtrack(boolean[] used,List<Integer> current,int[] nums,List<List<Integer>> result){

        if(current.size()==nums.length){
            result.add(new ArrayList(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            current.add(nums[i]);
            used[i]=true;

            backtrack(used,current,nums,result);

            used[i]=false;
            current.remove(current.size()-1);
        }
    }
}
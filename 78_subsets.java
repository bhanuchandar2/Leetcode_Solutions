class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> pro=new ArrayList<>();
        return subsets(nums,0,pro);
    }
    public static List<List<Integer>> subsets(int nums[],int index,List<Integer>pro){
        if(index==nums.length){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(pro));
            return list;
        }
        pro.add(nums[index]);
        List<List<Integer>> left=subsets(nums,index+1,pro);
        pro.remove(pro.size()-1);
        List<List<Integer>> right=subsets(nums,index+1,pro);
        left.addAll(right);
        return left;
    }
}
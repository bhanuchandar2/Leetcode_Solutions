class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        combinationsum(candidates,res,target,new ArrayList<>(),0);
        return res;
    }
    public static void combinationsum(int[] candidates,List<List<Integer>> res,int target,List<Integer> ds,int ind){
       if (target == 0) {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i=ind; i<candidates.length; i++ ){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }

            if(candidates[i]>target){
                break;
            }

            ds.add(candidates[i]);
            combinationsum(candidates,res,target-candidates[i],ds,i+1);
            ds.remove(ds.size()-1);
        }
    }
        
    
}
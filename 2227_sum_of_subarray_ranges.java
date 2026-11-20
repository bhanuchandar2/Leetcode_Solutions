class Solution {
    public long subArrayRanges(int[] nums) {
        int pse[]=pse(nums);
        int nse[]=nse(nums);
        int pge[]=pge(nums);
        int nge[]=nge(nums);
        long mintotal=0;
        long maxtotal=0;
        for(int i=0; i<nums.length; i++){
            int minleft=i-pse[i];
            int minright=nse[i]-i;
            mintotal=mintotal+(long)minright*minleft*nums[i];
            int maxleft=i-pge[i];
            int maxright=nge[i]-i;
            maxtotal=maxtotal+(long)maxright*maxleft*nums[i];
        }
        return maxtotal-mintotal;
    }
    public static int[] pse(int nums[]){
        int pse[]=new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }

    public static int[] nse(int nums[]){
        int nse[]=new int[nums.length];
        Stack<Integer> st =new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        return nse;
    }

    public static int[] pge(int nums[]){
        int pge[]=new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()]<nums[i]){
                st.pop();
            }
            pge[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pge;
    }

    public static int[] nge(int nums[]){
        int nge[]=new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i]){
                st.pop();
            }
            nge[i]=st.isEmpty()?nums.length:st.peek();
            st.push(i);
        }
        return nge;
    }
}
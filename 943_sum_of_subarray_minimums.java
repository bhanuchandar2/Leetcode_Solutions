class Solution {
    public int sumSubarrayMins(int[] arr) {
        int psee[]=psee(arr);
        int nse[] =nse(arr);
        long total=0;
        int mod=1000000007;
        for(int i=0; i<arr.length; i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(total+(long)left*right*arr[i])%mod;
        }
        return (int)total;
    }
    public static int[] psee(int[] arr){
        int[] pse=new int[arr.length];
        Stack<Integer> st =new Stack<>();
        for(int i=0; i<arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
    public static int[] nse(int[] arr){
        int[] nse=new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?arr.length:st.peek();
            st.push(i);
        }
        return nse;
    }
}
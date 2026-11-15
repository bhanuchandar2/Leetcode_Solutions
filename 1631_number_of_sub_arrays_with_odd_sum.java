class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=1;
        int odd=0;
        int mod=1000000007;
        int prefsum=0;
        int res=0;
        for(int i=0; i<arr.length; i++){
            prefsum=prefsum+arr[i];
            if(prefsum%2==0){
                res = (res + odd) % mod;
                even++;
            }
            else{
                 res = (res + even) % mod;
                 odd++;
            }
        }
        return res;

    }
}
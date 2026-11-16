class Solution {
    public String digitSum(String s, int k) {
        
        
        while(s.length()>k){
        int st=0;
        int sum=0;
        String res="";
        for(int i=0; i<s.length(); i++){
            sum+= Integer.parseInt(String.valueOf(s.charAt(i)));
            if(i-st+1==k){
                res+=String.valueOf(sum);
                sum=0;
                st=i+1;
            }
        }
        if (st < s.length()) {
            res += String.valueOf(sum);
        }
        s=res;
        }
        return s;
    }
}
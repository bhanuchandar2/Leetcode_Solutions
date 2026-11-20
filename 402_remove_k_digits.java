class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        if(k>=num.length()){
            return "0";
        }
        for(int i=0; i<num.length(); i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                st.pop();
                k-=1;
            }
            st.push(num.charAt(i));
        }

        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }

        StringBuilder res = new StringBuilder("");
        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }

        while(res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        if(res.length() == 0) {
            return "0";
        }

        return res.toString();
    }
}
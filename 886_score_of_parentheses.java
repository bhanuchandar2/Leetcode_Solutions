class Solution {
    public int scoreOfParentheses(String st) {
        
        int score=0;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<st.length(); i++){
            char ch=st.charAt(i);
            if(ch=='('){
                s.push(score);
                score=0;
            }
            else if(ch==')'){
                int current;
                if(score==0){
                    current=1;
                }
                else{
                    current=score=2*score;
                }
                score=s.pop()+current;
            }
            
        }
        return score;
    }
}
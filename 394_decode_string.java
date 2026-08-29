class Solution {
    public String decodeString(String st) {
        Stack<String> s = new Stack<>();
        
        for(int i=0; i<st.length(); i++){
            char ch=st.charAt(i);
            StringBuilder current = new StringBuilder();
            if(ch==']'){
                while(!s.peek().equals("[")){
                    current.insert(0,s.pop());
                }
                s.pop();
                StringBuilder mult = new StringBuilder();
                //we using .charAt(0) because s.peek() gives the string but Charcter.isDigit works on characters
                while(!s.isEmpty() && Character.isDigit(s.peek().charAt(0)) ){
                    mult.insert(0, s.pop());
                }
                int num=Integer.parseInt(mult.toString());
                StringBuilder result = new StringBuilder();

                for(int j = 0; j < num; j++){
                    result.append(current);
                }

                s.push(result.toString());
            }
            else{
                s.push(String.valueOf(ch));
            }
        }
        String ans="";
        while(!s.isEmpty()){
            ans=s.pop()+ans;
        }
        return ans;
    }
}
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for(int i=0; i<tokens.length; i++){
            String ch = tokens[i];
            
                
            if (ch.equals("+")) {
                int num1=s.pop();
                int num2=s.pop();
                s.push(num2 + num1);
            }
            else if (ch.equals("-")) {
                int num1=s.pop();
                int num2=s.pop();
                s.push(num2 - num1);
            }
            else if (ch.equals("*")) {
                int num1=s.pop();
                int num2=s.pop();
                s.push(num2 * num1);
            }
            else if (ch.equals("/")) {
                int num1=s.pop();
                int num2=s.pop();
                s.push(num2 / num1);
            }
            else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.peek();
    }
}
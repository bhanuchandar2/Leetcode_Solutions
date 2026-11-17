class Solution {
    public int calculate(String s) {
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i=0;
       while(i<s.length()){
            
             if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                String currstr="";
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                currstr += s.charAt(i);
                i++;
                }   
                operand.push(Integer.parseInt(currstr));
                continue;
            }
            else if(s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='/'|| s.charAt(i)=='*'){

                while(!operator.isEmpty() && !operand.isEmpty() &&  priority(s.charAt(i))<=priority(operator.peek())){
                    int top1=operand.pop();
                    int top2=operand.pop();
                    char ch=operator.pop();
                    if(ch=='+'){
                        operand.push(top2+top1);
                    }
                    else if(ch=='-'){
                        operand.push(top2-top1);
                    }
                    else if(ch=='*'){
                        operand.push(top2*top1);
                    }
                    else if(ch=='/'){
                        operand.push(top2/top1);
                    }
                }
                operator.push(s.charAt(i));
            }
            i++;
        }
        while(!operator.isEmpty()){
                    int top1=operand.pop();
                    int top2=operand.pop();
                    char ch=operator.pop();
                    if(ch=='+'){
                        operand.push(top2+top1);
                    }
                    else if(ch=='-'){
                        operand.push(top2-top1);
                    }
                    else if(ch=='*'){
                        operand.push(top2*top1);
                    }
                    else if(ch=='/'){
                        operand.push(top2/top1);
                    }
        }
        return operand.peek();
    }
    static int priority(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }
        else if(ch=='*' || ch=='/'){
            return 2;
        }
        return -1;
    }
}
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> hs = new HashMap<>();

        for(int i=0; i<knowledge.size(); i++){
            String key=knowledge.get(i).get(0);
            String value=knowledge.get(i).get(1);
            hs.put(key,value);
        }

        StringBuilder result = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){

                i+=1;
                String key="";

                while(s.charAt(i) !=')'){
                    key+=s.charAt(i);
                    i++;
                }
                
                if(hs.containsKey(key)){
                    result.append(hs.get(key));
                }
                else{
                    result.append('?');
                }
            }
            else{
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
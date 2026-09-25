class Solution {
    public List<Integer> findAnagrams(String s, String p) {
       List<Integer> result = new ArrayList<>();
       int k=p.length();
       HashMap<Character,Integer> hp = new HashMap<>();
       HashMap<Character,Integer> hs = new HashMap<>();
       for(char curr : p.toCharArray()) {
            hp.put(curr, hp.getOrDefault(curr, 0) + 1);
        }
       int l=0;
       for(int i=0; i<s.length(); i++){
        Character ch=s.charAt(i);
        hs.put(ch, hs.getOrDefault(ch, 0) + 1);
        while(i-l+1>k){
            Character left=s.charAt(l);
                hs.put(left, hs.get(left)-1);
                if(hs.get(left)==0){
                    hs.remove(left);
                }
                l++;
        }
        if(i-l+1==k){
            
            if(hs.equals(hp)){
               result.add(l);
            }
            }

        }
        return result;
    }
}
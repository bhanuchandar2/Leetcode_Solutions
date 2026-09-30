class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hs=new HashMap<>();
        int max=0;
        int l=0;
        for(int i=0; i<s.length(); i++){
            char ch=s.charAt(i);
            if(hs.containsKey(ch)){
                l=Math.max(l,hs.get(ch)+1);
            }
            hs.put(ch,i);
            max=Math.max(max,i-l+1);
        }
        return max;
    }
}
class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.get(s.charAt(r))>2){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                l++;
            }
            if(r-l+1>max){
                max=r-l+1;
            }
            r++;
        }
        return max;
    }
}
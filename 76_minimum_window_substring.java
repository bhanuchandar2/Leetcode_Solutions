class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> tmap = new HashMap<>();
        HashMap<Character,Integer> smap = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            tmap.put(t.charAt(i),tmap.getOrDefault(t.charAt(i),0)+1);
        }
        int count=0;
        int l=0;
        int min = Integer.MAX_VALUE;
        int minStart = 0;
        for(int i=0; i<s.length(); i++){
            if(tmap.containsKey(s.charAt(i))){
                if(smap.getOrDefault(s.charAt(i), 0) < tmap.get(s.charAt(i))){
                    count++;
                }
                smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            }

            while(count==t.length()){
                if(i-l+1<min){
                    min=i-l+1;
                    minStart=l;
                }

                if(tmap.containsKey(s.charAt(l))){
                    char ch = s.charAt(l);
                    smap.put(s.charAt(l), smap.get(ch) - 1);

                    if (smap.get(ch) < tmap.get(ch)) {
                        count--;
                    }
                }
                l++;
            }


            
            
        }
        if(min == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(minStart, minStart + min);
    }
}
class Solution {
    public int minRotations(String s) {
      int rot=0;
      int prev=0;
      for(int i=0; i<s.length(); i++){
        int curr = s.charAt(i) - '0';
        
        int diff=Math.abs(prev-curr);
        rot+=Math.min(diff,10-diff);
        prev=curr;
    
      }
      return rot;
    }
}
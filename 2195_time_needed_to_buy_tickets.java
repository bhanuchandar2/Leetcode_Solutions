class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int curr=0;
        int count=0;
        while(tickets[k]!=0){
            if(tickets[curr]!=0){
                count+=1;
                tickets[curr]=tickets[curr]-1;
            }
            curr=(curr+1)%tickets.length;
        }
        return count;
    }
}
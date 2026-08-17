/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp=head;
        int len=1;
        while(temp.next!=null){
            temp=temp.next;
            len+=1;
        }
        ListNode tail=temp;
        ListNode newtail=head;
        k=k%len;
        if(k==0){
            return head;
        }
        for(int i=0;i<len-k-1;i++){
            newtail=newtail.next;
        }
        ListNode newhead=newtail.next;
        
        newtail.next=null;
        tail.next=head;
        
        return newhead;
}

}
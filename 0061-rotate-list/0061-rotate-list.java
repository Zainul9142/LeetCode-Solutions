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
        if(head == null || head.next == null || k == 0)
            return head;
        
        int len = 1;
        ListNode tail = head;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        tail.next = head;
        k = len - (k % len);
        while(k --> 0) 
        tail = tail.next;

        head = tail.next;
        tail.next = null;
        return head;
    }
}
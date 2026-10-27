/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0;
        ListNode tempA = headA;
        while (tempA != null) {
            n1++;
            tempA = tempA.next;
        }

        int n2 = 0;
        ListNode tempB = headB;
        while (tempB != null) {
            n2++;
            tempB = tempB.next;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        int diff = Math.abs(n1 - n2);

        if (n1 > n2) {
            while (diff > 0) {
                currA = currA.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                currB = currB.next;
                diff--;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB) {
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }
}
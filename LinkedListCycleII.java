/** 142. Linked List Cycle II
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

First Step: Assume the first pointer runs from head at a speed of 1-by-1 step, as S, and the second pointer runs at a speed of 2-by-2 step, as 2S, then two pointers will meet at MEET-POINT, using the same time. Define outer loop is A, the distance from CIRCLE-START-POINT to MEET-POINT is B, and the distance from MEET-POINT to CIRCLE-START-POINT is C (Apparently, C=loop-B), then (n*loop+a+b)/2S = (a+b)/S, n=1,2,3,4,5,....

Converting that equation can get A/S=nloop/S-B/S. Since C=loop-B, get A/S = ((n-1)loop+C)/S.

That means, as second step, assuming a pointer running from head and another pointer running from MEET-POINT both at a speed S will meet at CIRCLE-START-POINT;

    (CIRCLE-START-POINT)
            |
-------A----@----------------
            |               |
            |               |
            C               B
            |               |
            |-------@-------|
                    |
               (MEET-POINT)
*/

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null || head.next.next==null){
            return null;
        }
        ListNode pointer1 = head.next;
        ListNode pointer2 = head.next.next;
        //Step 1
        while(pointer1!=pointer2){
            if(pointer2.next==null || pointer2.next.next==null){
                return null;
            } 
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        pointer1 = head;
        //Step 2
        while(pointer1!=pointer2){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer2;
    }
}
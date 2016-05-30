/** 147. Insertion Sort List
Sort a linked list using insertion sort.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode sortedHead = head, sortedTail = head;
        head = head.next;
        sortedHead.next = null;
        
        while(head != null){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            
            //val is less than head, insert in the front
            if(temp.val <= sortedHead.val){
                temp.next = sortedHead;
                sortedTail = sortedHead.next == null? sortedHead : sortedTail;
                sortedHead = temp;
            } 
            //val is greater than the tail, insert in the end
            else if (temp.val >= sortedTail.val){
                sortedTail.next = temp;
                sortedTail = sortedTail.next;
            }
            //val is between start and end, find where to insert
            else {
                ListNode curr = sortedHead;
                while(curr.next != null && curr.next.val < temp.val){
                    curr = curr.next;
                } 
                temp.next = curr.next;
                curr.next = temp;
            }
        }
        return sortedHead;
    }
}
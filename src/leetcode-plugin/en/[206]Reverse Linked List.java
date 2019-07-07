//Reverse a singly linked list. 
//
// Example: 
//
// 
//Input: 1->2->3->4->5->NULL
//Output: 5->4->3->2->1->NULL
// 
//
// Follow up: 
//
// A linked list can be reversed either iteratively or recursively. Could you implement both? 
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode reverseList(ListNode head) {
    //     if(head == null){
    //         return null;
    //     }
    //     ListNode prev = new ListNode(head.val);
    //     head = head.next;
    //     ListNode current=prev;
    //     while(head != null){
    //         current = new ListNode(head.val);
    //         current.next = prev;
    //         prev = current;
    //         head = head.next;
    //     }
    //     return current;
    // }

    public ListNode reverseList(ListNode head) {
        return solve(head, null, null);
    }

    public ListNode solve(ListNode head, ListNode current, ListNode prev){
        if(head == null){
            return current;
        }
        current = new ListNode(head.val);
        current.next = prev;
        prev = current;
        return solve(head.next, current, prev);
    }

}
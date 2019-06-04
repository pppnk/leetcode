//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver=0,val1,val2,res;
        ListNode answer=null,head=null;
        while(l1 != null || l2 != null || carryOver != 0){
            val1 = l1 == null? 0: l1.val;
            val2 = l2 == null? 0: l2.val;
            res=val1+val2+carryOver;
            if(answer==null){
                answer = new ListNode(0);
                head = answer;
            } else {
                answer.next = new ListNode(0);
                answer = answer.next;
            }
            answer.val = res % 10;
            l1 = l1 == null? null: l1.next;
            l2 = l2 == null? null: l2.next;
            carryOver = res >= 10? res/10 : 0;
        }
        return head;
    }
}
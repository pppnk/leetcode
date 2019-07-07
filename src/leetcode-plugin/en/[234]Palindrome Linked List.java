//Given a singly linked list, determine if it is a palindrome. 
//
// Example 1: 
//
// 
//Input: 1->2
//Output: false 
//
// Example 2: 
//
// 
//Input: 1->2->2->1
//Output: true 
//
// Follow up: 
//Could you do it in O(n) time and O(1) space? 
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
    public boolean isPalindrome(ListNode head) {
        ListNode middle = head, curr = head;
        int n = 0, lowHalfElements = 0;
        Stack<Integer> stack = new Stack();
        while(curr != null){
            n++;
            if((n + 1)/2 > lowHalfElements){
                stack.push(middle.val);
                middle = middle.next;
                lowHalfElements++;
            }
            curr = curr.next;
        }
        curr = middle;
        if(n % 2 != 0){
            stack.pop();
        }
        int tmp;
        while(curr != null && !stack.isEmpty()){
            tmp = stack.pop();
            if(tmp != curr.val){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3486/

Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
*/

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
      int size = 1;
      
      ListNode temp = head;
      if(head == null || head.next == null)
        return head;
      
      while(temp.next != null){
        size++;
        temp = temp.next;
      }
      
      k = k%size;
      if(k == 0)
        return head;
      
      temp.next = head;
      
      
      temp = head;
      int i = 0;
      while(i < size - k - 1) {
        // System.out.println(i);
        temp = temp.next;
        i++;
      }
      
      head = temp.next;
      temp.next = null;
      // System.out.println(">>"+ temp.val);
      
      
      return head;
    }
}

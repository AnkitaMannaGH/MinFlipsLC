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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
        ListNode before = null;
        ListNode after = null;
      
        int count = 1;
        while(count<a){
            count++;
            list1 = list1.next;
        }
        
        before = list1;
        
        while(count<=b+1){
            count++;
            list1 = list1.next;
        }
        
        after = list1;
        
        while(list2!=null){
            before.next = list2;
            before= before.next;
            list2 = list2.next;
        }
        
        before.next = after;
        before = before.next;
        
        return head;
    }
}
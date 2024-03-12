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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        map.put(prefix, dummy);
        while (head != null) {
            prefix += head.val;
            if (map.containsKey(prefix)) {
                head = map.get(prefix).next;
                int tempPrefix = prefix + head.val;
                while (tempPrefix != prefix) {   // remove the skipped nodes from map
                    map.remove(tempPrefix);
                    head = head.next;
                    tempPrefix += head.val;
                }
                map.get(prefix).next = head.next;
            } else {
                map.put(prefix, head);
            }
            head = head.next;
        }
        return dummy.next;
    }
}
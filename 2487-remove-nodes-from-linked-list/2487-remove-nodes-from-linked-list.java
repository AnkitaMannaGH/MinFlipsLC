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
    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int largestValue = Integer.MIN_VALUE;
        List<Integer> values = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) < largestValue) {
                continue;
            }
            largestValue = Math.max(largestValue, list.get(i));
            values.add(list.get(i));
        }
        Collections.reverse(values);
        ListNode result = new ListNode(values.get(0));
        ListNode pointer = result;
        for (int i = 1; i < values.size(); i++) {
            result.next = new ListNode(values.get(i));
            result = result.next;
        }
        return pointer;
    }
}
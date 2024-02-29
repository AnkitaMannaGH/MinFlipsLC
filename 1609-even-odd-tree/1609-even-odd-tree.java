/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        boolean even = true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            for (int i = 0, l = q.size(), p = -1; i < l; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                if (i == 0) {
                    p = curr.val;
                    if (even && p % 2 == 0) return false;
                    if (!even && p % 2 == 1) return false;
                    continue;
                }
                if (even && (curr.val <= p || curr.val % 2 != 1)) return false;
                if (!even && (curr.val >= p || curr.val % 2 == 1)) return false;
                p = curr.val;
            }
            even = !even;
        }
        return true;
    }
}
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
    int result = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return result;
    }
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        if (left[0] > left[1]) { 
            result += left[0] - left[1];
        }
        if (right[0] > right[1]) { 
            result += right[0] - right[1];
        }
        int[] ret = new int[]{left[0] + right[0] + 1, left[1] + right[1] + root.val};
        if (ret[1] > ret[0]) {  
            result += ret[1] - ret[0];
        }
        return ret;
    }
}
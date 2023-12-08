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
    public String tree2str(TreeNode root) {
    if (root == null)
		return "";

	var str = new StringBuilder().append(root.val);
	if (root.left == null && root.right == null)
		return str.toString();

	str.append('(')
	   .append(tree2str(root.left))
	   .append(')');

	if (root.right != null)
		str.append('(')
		   .append(tree2str(root.right))
		   .append(')');

	return str.toString();
    }
}
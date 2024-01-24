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
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] arr = new int[10];  // record each node of a path occurence, arr[1]==1 means the node which node.val==1 appear once
        dfs(root, arr);
        return res;
    }
    void dfs(TreeNode node, int[] arr) {
        arr[node.val]++;  // record node occurence
        if (node.left == null && node.right == null) { // deal with leaf node
            int oddCount = 0;
            for (int i=1; i<=9; i++) {
                if (arr[i]%2 == 1) oddCount++;
            }
            if (oddCount <= 1) res++; // if only one or zero odd count, the path must be pseudo-palindromic
        }
        if (node.left != null) dfs(node.left, arr);
        if (node.right != null) dfs(node.right, arr);
        arr[node.val]--; // reset the original state
    }
}
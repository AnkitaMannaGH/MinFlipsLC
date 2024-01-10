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
    public int amountOfTime(TreeNode root, int start) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    dfs(root, null, map);
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    visited.add(start);
    int cnt = map.entrySet().size();
    int res = 0;
    while(!q.isEmpty()){
        int size = q.size();
        for(int i=0;i<size;i++){
            int cur = q.poll();
            cnt--;
            if(cnt == 0)
                return res;
            for(int nei : map.getOrDefault(cur, new HashSet<>())){
                if(visited.add(nei))
                    q.offer(nei);
            }
        }
        res++;
    }
    return 0;
}

void dfs(TreeNode cur, TreeNode parent, Map<Integer, Set<Integer>> map){
    if(cur == null)
        return;
    if(parent != null) {
        map.putIfAbsent(parent.val, new HashSet<>());
        map.get(parent.val).add(cur.val);
        map.putIfAbsent(cur.val, new HashSet<>());
        map.get(cur.val).add(parent.val);
    }
    dfs(cur.left, cur, map);
    dfs(cur.right, cur, map);
}
}
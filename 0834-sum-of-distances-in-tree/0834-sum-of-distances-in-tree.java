class Solution {
  private Map<Integer, List<Integer>> tree;
  private int[] cnt;
  private int[] res;
  public int[] sumOfDistancesInTree(int N, int[][] edges) {
    tree = new HashMap<>();
    for (int i = 0; i < N; i++) tree.put(i, new ArrayList<>());
    for (int[] e: edges) {
      tree.get(e[0]).add(e[1]);
      tree.get(e[1]).add(e[0]);
    }
    cnt = new int[N];
    res = new int[N];
    dfs1(0, -1);
    dfs2(0, -1);
    return res;
  }
  private void dfs1(int node, int parent) {
    for (int next: tree.get(node)) {
      if (next == parent) continue;
      dfs1(next, node);
      cnt[node] += cnt[next];
      res[node] += res[next] + cnt[next];
    }
    cnt[node]++;
  }
  private void dfs2(int node, int parent) {
    for (int next: tree.get(node)) {
      if (next == parent) continue;
      res[next] = res[node] - cnt[next] + cnt.length - cnt[next];
      dfs2(next, node);
    }
  }
}
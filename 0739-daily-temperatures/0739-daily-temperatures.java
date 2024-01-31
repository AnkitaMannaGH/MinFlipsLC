class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        final int m = temperatures.length;
        final Map<Integer, Integer> next = new HashMap<>();
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < m; i++) {
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]) {
                next.put(stack.peek(), i - stack.pop());
            }
            stack.push(i);
        }
        final int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = next.getOrDefault(i, 0);
        }
        return ans;
    }
}
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            int d = i, n = d;
            while (n <= high && d++ <= 9) {
                if (n >= low) res.add(n);
                int next = n * 10 + d;
                if (next <= n) break; //overflow;
                n = next;
            }
        }
        Collections.sort(res);
        return res;
    }
}
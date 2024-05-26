class Solution {
    long max_limit_ = 1000000007;
    public int checkRecord(int n) {
        if (n <= 0) return 0;
        long[][][][] f = new long[2][4][4][n];
        return (int) (find(0, 0, 0, 0, n, f) % max_limit_);
    }
    long find(int num_A, int pprev, int prev, int pos, int n, long[][][][] f) {
        if (pos == n)
        {
            return 1;
        }
        if (f[num_A][pprev][prev][pos] != 0) 
            return f[num_A][pprev][prev][pos];
        long result = find(num_A, prev, 3, pos + 1, n, f);
        if (num_A == 0)
        {
            result += find(1, prev, 1, pos + 1, n, f);
        }
        if (prev == 0 || pprev == 0 || !(pprev == 2 && prev == 2))
        {
            result += find(num_A, prev, 2, pos + 1, n, f);
        }
        return f[num_A][pprev][prev][pos] = result % max_limit_;
    }
}
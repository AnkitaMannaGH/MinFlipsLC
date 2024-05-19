class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[] diffs = new long[n];
        
        for (int i = 0; i < n; ++i) {
            diffs[i] = (nums[i] ^ k) - nums[i];
        }
        
        Arrays.sort(diffs);
        
        long ans = 0;
        for (int x : nums) {
            ans += x;
        }
        
        for (int i = n - 1; i >= 1; i -= 2) {
            long ta = diffs[i] + diffs[i - 1];
            if (ta < 0) {
                return ans;
            }
            ans += ta;
        }
        
        return ans;
    }
}
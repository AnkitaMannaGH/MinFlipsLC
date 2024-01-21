class Solution {
    public int rob(int[] nums) {
         int m1 = 0, m2 = 0;
        for(int i = 0; i < nums.length;  i++) {
            int tmp = Math.max(nums[i] + m1, m2);
            m1 = m2;
            m2 = tmp;
        }
        return m2;
    }
}
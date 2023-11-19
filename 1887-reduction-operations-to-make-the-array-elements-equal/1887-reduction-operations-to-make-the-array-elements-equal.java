class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] != nums[i]) {
                ans += nums.length - i;
            }
        }
        return ans;
    }
}
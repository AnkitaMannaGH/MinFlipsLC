class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int[] result = new int[2];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                result[0] = nums[i];
                break;
            }
        }
        int ni = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (ni + 1 < nums.length && nums[ni] != i && nums[ni + 1] != i) {
                result[1] = i;
                return result;
            }
            ni++;
        }
        result[1] = nums.length;
        return result;
    }
}
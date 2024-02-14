class Solution {
    public int[] rearrangeArray(int[] nums) {
        int N = nums.length;
        int pos = 0, neg = 0;
        int[] ret = new int[N];
        int cur = 0;
        while(pos < N && neg < N)
        {
            while(nums[pos] < 0 && pos < N)
                pos++;
            while(nums[neg] >= 0 && neg < N)
                neg++;
            ret[cur++] = nums[pos++];
            ret[cur++] = nums[neg++];
        }
        return ret;
    }
}
class Solution {
    public int minPairSum(int[] nums) {
     Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        int l = 0;
        int r = nums.length-1;
        
        while(l<r){
            int sum = nums[l] + nums[r];
            max = Math.max(sum, max);
            l++;
            r--;
        }
        return  max;   
    }
}
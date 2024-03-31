class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int lastMax = -1;
        int lastMin = -1;
        int lastOut = -1;
        
        long total = 0;
        
        for (int i = 0; i < nums.length; ++i){
            
            if (nums[i] == minK){
                lastMin = i;
            }
            
            if (nums[i] == maxK){
                lastMax = i;
            }
            
            if (nums[i] < minK || nums[i] > maxK){
                lastOut = i;
            }
            
            total += Math.max(0 , Math.min(lastMin , lastMax) - lastOut);
        }
        
        return total;
    }
}
class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        long max = 1;
        for (int num : nums) {
            hs.add(num);
            max = Math.max(num, max);
        }
        for (int i = 1; i <= max + 1; i++) {
            if (!hs.contains(i)) return i;
        }
        return 0;
    }
}
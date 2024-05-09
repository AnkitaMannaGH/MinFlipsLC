class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
       Arrays.sort(happiness);
        int cnt = 0;
        long res = 0;
        for (int i = happiness.length - 1; i > -1; i --) {
            int h = happiness[i];
            if (h - cnt > 0) {
                res += (long)(h - cnt);
                cnt ++;
            }
            if (cnt == k || h - cnt <= 0) {
                break;
            }
        }
        return res; 
    }
}
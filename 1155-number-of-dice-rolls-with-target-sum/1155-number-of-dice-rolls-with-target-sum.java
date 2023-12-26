class Solution {
    private static final int MOD = 1000000000 + 7;
    private Map<String, Integer> cache = new HashMap<>();
    
    public int numRollsToTarget(int d, int f, int target) {
        if (target <= 0) return 0;
        if (d == 1 && target <= f) return 1;
        else if (d == 1) return 0;
        
        String key = d + "-" + target;
        if (cache.containsKey(key)) {
            //System.out.println("cache hit!");
            return cache.get(key);    
        }
        else {
            int numWays = 0;
            for (int i = 1; i <= f; i++) {
                int newTarget = target - i;
                numWays = (numWays + numRollsToTarget(d - 1, f, target - i)) % MOD;
            }    
            cache.put(key, numWays);
        }
        
        return cache.get(key);
    }
}
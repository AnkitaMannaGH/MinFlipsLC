class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        return helper(A, K) - helper(A, K-1);
    }
    
    int helper(int[] A, int K) {
        int res = 0, i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int j = 0; j < A.length; j++) {
            int count = map.getOrDefault(A[j], 0);
            if(count == 0) K--;
            map.put(A[j], count + 1);
            
            while(K < 0) {
                map.put(A[i], map.get(A[i])-1);
                if(map.get(A[i]) == 0) K++;
                i++;
            }
            res += j - i + 1;
        }
        
        return res;
    }
}
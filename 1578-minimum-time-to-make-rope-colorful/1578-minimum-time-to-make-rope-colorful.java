class Solution {
    public int minCost(String colors, int[] neededTime) {
      int ans = 0;
      for(int i = 1; i < colors.length(); i++)
      if(colors.charAt(i) == colors.charAt(i-1)){
        ans += neededTime[i-1];
        int j = i, maxi = neededTime[i-1];
		
        for(; j != colors.length() && colors.charAt(i) == colors.charAt(j); j++){
          ans += neededTime[j];
          maxi = Math.max(maxi, neededTime[j]);
        }
		
        ans -= maxi;
        i = j;
      }
    
    return ans;
    }
}
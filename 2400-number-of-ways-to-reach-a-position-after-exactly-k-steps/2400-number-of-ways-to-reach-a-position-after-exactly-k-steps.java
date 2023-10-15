class Solution {
    int mod= 1000000007;
    
    public int numberOfWays(int stPos, int endPos, int k) {
        int[][] dp= new int[5001][1001];
        for(int i=0; i<5001; i++){
            for(int j=0; j<1001 ; j++){
                dp[i][j]= -1;
            }
        }
        return solve(stPos,endPos,stPos,k,dp)%mod;
    }
    
    public int solve(int stpos, int endpos, int curr, int k, int[][] dp){
        if(k==0){
            if(curr==endpos){
                return 1;
            }
            return 0;
        }
        
        if(dp[curr+1000][k]!=-1){
            return dp[curr+1000][k]%mod;
        }
        
        return dp[curr+1000][k] = (solve(stpos,endpos,curr+1,k-1,dp)%mod + solve(stpos,endpos,curr-1,k-1,dp)%mod)%mod;    
    }
}
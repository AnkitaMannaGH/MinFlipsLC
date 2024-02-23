class Solution {
    Map<Integer,List<int[]>>map;
    Integer dp[][];
    int find(int src,int dest,int k){
        if(k<0)return 1000_000_00;
        if(src==dest)return 0;
        if(dp[src][k]!=null)return dp[src][k];
        int max=1000_000_00;
        for(int arr[] : map.getOrDefault(src,new ArrayList<>())){
            max=Math.min(max,arr[1]+find(arr[0],dest,k-1));
        }
        return dp[src][k]=max;
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        map=new HashMap<>();
        dp=new Integer[n+1][K+2];
        for(int a[] : flights){
            map.computeIfAbsent(a[0],k -> new ArrayList<>());
            map.get(a[0]).add(new int[]{a[1],a[2]});
        }
        int temp=find(src,dst,K+1);
        return temp>=1000_000_00 ? -1 : temp;
    }
}
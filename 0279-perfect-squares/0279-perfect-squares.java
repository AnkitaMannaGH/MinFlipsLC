class Solution {
     Map<Integer,Integer>map;
    int find(int n){
        if(map.containsKey(n))
            return map.get(n);
        if(n<=3)
            return n;
        int min=100000;
        for(int i=1;i*i<=n;i++){
            min=Math.min(min,1+find(n-i*i));
        }
        map.put(n,min);
        return min;
    }
    public int numSquares(int n) {
        map=new HashMap<>();
        return find(n);
    }
}
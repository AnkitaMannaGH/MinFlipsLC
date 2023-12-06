class Solution {
    public int totalMoney(int n) {
        int res = 0;
        int monday = 0;
        int cur = 1;
        for(int i = 0;i<n;i++){
            if(i%7 == 0){
                monday++;
                cur = monday;
            }
            res+=cur++;
        }
        return res;
    }
}
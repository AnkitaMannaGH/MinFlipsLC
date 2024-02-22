class Solution {
    public int findJudge(int n, int[][] trust) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> judge = new HashSet<Integer>();
        if(trust.length == 0 && n==1){
            return 1;
        }
        else if(trust.length == 0){
            return -1;
        }
        for(int i = 0; i<trust.length; i++){
            set.add(trust[i][0]);
            judge.add(trust[i][1]);
        }
        judge.removeAll(set);
        if(judge.isEmpty() || judge.size() > 1) {
            return -1;
        }
        int judgeId = judge.iterator().next();
        int judgeTrust = 0;
        for(int i = 0; i<trust.length; i++) {
            if(trust[i][1] == judgeId) {
                judgeTrust++;
            }
        }
        if(judgeTrust == n-1) {
            return judgeId;
        }
        return -1;
    }
}
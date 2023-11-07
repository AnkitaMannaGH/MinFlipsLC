class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
         PriorityQueue<Integer> turnsToCity = new PriorityQueue<>((a,b) -> (((double)dist[a]) / speed[a] < ((double)dist[b]) / speed[b]) ? -1 : 1);
        int turns = 0, n = dist.length;
        for (int i = 0 ; i < n; i++) turnsToCity.offer(i);
        while(!turnsToCity.isEmpty()){
            int closest = turnsToCity.poll() , location = dist[closest] - speed[closest] * turns;
            if (location <= 0) break;
            turns++;
        }
        return turns;
    }
}
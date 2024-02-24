class Solution {
    private Set<Integer> people = new HashSet<>();
    private Map<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<>();
    
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        
        for (int[] meeting : meetings) {
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];
            map.putIfAbsent(p1, new HashMap<>());
            map.putIfAbsent(p2, new HashMap<>());
            map.get(p1).putIfAbsent(time, new ArrayList<>());
            map.get(p2).putIfAbsent(time, new ArrayList<>());
            map.get(p1).get(time).add(p2);
            map.get(p2).get(time).add(p1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        pq.add(new int[]{0, 0});
        pq.add(new int[]{0, firstPerson});
        
        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            int time = tuple[0];
            int person = tuple[1];
            if (people.contains(person)) {
                continue;
            }
            people.add(person);
            if (!map.containsKey(person)) {
                continue;
            }
            for (Map.Entry<Integer, List<Integer>> e : map.get(person).entrySet()) {
                int nextTime = e.getKey();
                List<Integer> meetPeople = e.getValue();
                if (nextTime < time) {
                    continue;
                }
                for (int p : meetPeople) {
                    if (people.contains(p)) {
                        continue;
                    }
                    pq.add(new int[]{e.getKey(), p});
                }
            }   
        }
        List<Integer> result = new ArrayList<>(people);
        return result;
    }
}
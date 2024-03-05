class Solution {
    public int minimumLength(String s) {
        Deque<Character> q = new LinkedList<>();
	for(char c: s.toCharArray()) q.offer(c);
	while(!q.isEmpty()) {
		if(q.size()==1) return 1;
		char c = q.peekFirst();
		if(c == q.peekLast()) {
			while(!q.isEmpty() && c == q.peekLast()) q.pollLast();
			while(!q.isEmpty() && c == q.peekFirst()) q.pollFirst();
		} else break;
	}
	return q.size();
    }
}
class Solution {
    public int maxDepth(String s) {
        int op = 0;
	int max = 0;
	for(char ch: s.toCharArray()) {
		if(ch=='(')
			++op;
		else if(ch==')') {
			if (max < op)
				max = op;
			--op;
		}            
	}
	return max;
    }
}
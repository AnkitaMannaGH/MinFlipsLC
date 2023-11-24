class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
    	int maxIndex = piles.length - 1;
    	int minIndex = 0;
    	int sum = 0;
    	while(minIndex < maxIndex) {
    		maxIndex--;
    		sum += piles[maxIndex--];
    		minIndex++;
    	}
    	return sum;
    }
}
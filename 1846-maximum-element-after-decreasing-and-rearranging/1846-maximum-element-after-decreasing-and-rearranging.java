class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
	int current = 1;
	for(int i=1;i<arr.length;i++) 
		if(arr[i] > current + 1) current = current + 1;
		else current = arr[i];
	return current;
    }
}
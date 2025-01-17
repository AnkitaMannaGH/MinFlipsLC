class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> resultList = new ArrayList<>();
	for (int i=0;i<land.length;i++) 
		for (int j=0;j<land[0].length;j++)
			if (land[i][j]==1 && (i==0||land[i-1][j]==0) && (j==0 ||land[i][j-1]==0)) {
				int i2 = i, j2 = j;
				while (i2<land.length && land[i2][j] == 1) i2++;
				while (j2<land[0].length && land[i][j2] == 1) j2++;
				resultList.add(new int[]{i,j,i2-1,j2-1}); 
			}
	return resultList.toArray(new int[0][]);
    }
}
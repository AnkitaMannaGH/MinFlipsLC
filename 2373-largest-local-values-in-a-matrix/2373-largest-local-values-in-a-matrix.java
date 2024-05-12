class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[][] ans = matrixMin(grid);
        return ans;    
    }
    public int[][] matrixMin(int[][]grid){
        int[][] ans= new int[grid.length - 2][grid[0].length -2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
 
                int max = Integer.MIN_VALUE;
                for (int k = j; k < j + 3; k++) {
                    max = Math.max(max, grid[i][k]);
                }
                grid[i][j] = max;
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length - 2; i++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k < i + 3; k++) {
                    max = Math.max(max, grid[k][j]);
                }
                grid[i][j] = max;
            }
        }
        for (int i = 0; i < grid.length - 2; i++)
            for (int j = 0; j < grid[0].length - 2; j++)
                ans[i][j] = grid[i][j];
        return ans;    
    }
}
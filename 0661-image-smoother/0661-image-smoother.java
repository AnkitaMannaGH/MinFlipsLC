class Solution {
     public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                smooth(res, M, m, n, i, j);
            }
        }
        return res;
    }
            
    private void smooth(int[][] res, int[][] M, int m, int n, int i, int j) {
        int sum = 0, count = 0;
        
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int nx = i + x, ny = j + y;
                if (nx >=0 && nx < m && ny >=0 && ny < n) {
                    sum += M[nx][ny];
                    count++;
                }
            }
        }
        res[i][j] = (int) Math.floor(sum / count);
    }
}
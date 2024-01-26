class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int mod=1000000007;
        long[][] matrix=new long[m][n];
        long[][] matrix_tmp=new long[m][n];
        for(int cnt=1;cnt<=N;cnt++){
            for(int row=0;row<m;row++){
                for(int col=0;col<n;col++){
                    matrix[row][col]=0;
                    matrix[row][col]+=row-1<0?1L:matrix_tmp[row-1][col];
                    matrix[row][col]+=row+1>=m?1L:matrix_tmp[row+1][col];
                    matrix[row][col]+=col+1>=n?1L:matrix_tmp[row][col+1];
                    matrix[row][col]+=col-1<0?1L:matrix_tmp[row][col-1];
                }
            }
            for(int row=0;row<m;row++){
                for(int col=0;col<n;col++){
                    matrix_tmp[row][col]=matrix[row][col]%mod;
                }
            }
        }
        return (int)matrix_tmp[i][j];
    }
}
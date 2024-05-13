class Solution {
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for (int i = 0; i < m; ++i) {
            if (A[i][0] == 0) {
                toggleRow(A, i);
            }
        }
        int lessThanHalf = 0;
        if (m % 2 == 0) { 
            lessThanHalf = m / 2 - 1;
        } else { 
            lessThanHalf = m / 2;
        }
        for (int j = 1; j < n; ++j) {
            if (countSetBitsInColumn(A, j) <= lessThanHalf) {
                toggleColumn(A, j);
            }
        }
        int[] bitPlaceValues = new int[n];
        bitPlaceValues[n - 1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            bitPlaceValues[i] = bitPlaceValues[i + 1] * 2;
        }        
        int matrixSum = 0;
        for (int i = 0; i < m; ++i) {
            int rowSum = 0;
            for (int j = 0; j < n; ++j) {
                rowSum += bitPlaceValues[j] * A[i][j];
            }
            matrixSum += rowSum;
        }        
        return matrixSum;
    }    
    private void toggleColumn(int[][] arr, int column) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i][column] == 1) {
                arr[i][column] = 0;
            } else { 
                arr[i][column] = 1;
            }
        }
    }
    private void toggleRow(int[][] arr, int row) {
        for (int j = 0; j < arr[row].length; ++j) {
            if (arr[row][j] == 1) {
                arr[row][j] = 0;
            } else { 
                arr[row][j] = 1;
            }
        }
    }
    private int countSetBitsInColumn(int[][] arr, int column) {
        int numSetBits = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i][column] == 1) {
                ++numSetBits;
            }
        }
        return numSetBits;
    }
}
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                if (dfs(board,visited, arr,0, i, j)) {
                    return true;
                } else {
                    visited[i][j] = false;
                }
            }
        }
        return false;
        
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, char[] arr, int index, int row, int col) {
        if (arr[index] != board[row][col]) {
            return false;
        } 
        if (index == arr.length - 1) {
            return true;
        }
        int[] rHelp = new int[]{1,-1,0,0};
        int[] cHelp = new int[]{0,0,1, -1};
        for (int i = 0; i < 4; i++) {
            int nextRow = row + rHelp[i];
            int nextCol = col + cHelp[i];
            if (isValid(board, visited, nextRow, nextCol)) {
                visited[nextRow][nextCol] = true;
                if (dfs(board,visited, arr, index + 1, nextRow, nextCol)) {
                    return true;
                } else {
                    visited[nextRow][nextCol] = false;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, boolean[][] visited, int row, int col) {
        int rowMax = board.length - 1;
        int colMax = board[0].length - 1;
        if (row >= 0 && row <= rowMax && col >= 0 && col <= colMax && !visited[row][col]) {
            return true;
        } else {
            return false;
        }
    }
}
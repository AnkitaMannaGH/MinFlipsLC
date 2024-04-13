class Solution {
   public int area(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0, i = 0;
        while(i < arr.length){
            if(stack.isEmpty() || arr[stack.peek()] <= arr[i])
                stack.push(i++);
            else{
                int top = stack.pop();
                maxArea = Math.max(maxArea, arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));       
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            maxArea = Math.max(maxArea, arr[top] * (stack.isEmpty() ? i : i - stack.peek() - 1));      
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return 0;
        int cols = matrix[0].length;
        int[] arr = new int[cols];
        int max = 0;
        for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){
               if(matrix[i][j] == '1')
                   arr[j]++;
               else
                   arr[j] = 0;
           } 
            int area = area(arr);
            if(area > max)
                max = area;
        }
        return max;
    }
}
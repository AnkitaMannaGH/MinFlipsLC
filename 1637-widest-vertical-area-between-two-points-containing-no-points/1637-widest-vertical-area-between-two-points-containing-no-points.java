class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        if(points == null || points.length == 0) return 0;
        Arrays.sort(points, java.util.Comparator.comparingInt(point -> point[0]));
        int wva = points[1][0] - points[0][0];
        for(int i = 1; i < points.length - 1; i++){
            wva = Math.max(wva, points[i + 1][0] - points[i][0]);
        }
        return wva;
    }
}
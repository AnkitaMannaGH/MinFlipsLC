class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minNumberOfPoints = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int xDistance = Math.abs(points[i + 1][0] - points[i][0]);
            int yDistance = Math.abs(points[i + 1][1] - points[i][1]);
            minNumberOfPoints = minNumberOfPoints + Math.max(xDistance, yDistance);
        }
        return minNumberOfPoints;
    }
}
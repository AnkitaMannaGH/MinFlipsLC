class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        var arrows = 1;
        var prevEnd = points[0][1];

        for (var point : points) {
            var start = point[0];
            var end = point[1];

            if (start > prevEnd) {
                prevEnd = end;
                arrows++;
            } else {
                prevEnd = Math.min(prevEnd, end);
            }
        }

        return arrows; 
    }
}
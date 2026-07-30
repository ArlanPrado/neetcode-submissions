class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> pointCompare = (a, b) -> Double.compare(distanceFromOrigin(a), distanceFromOrigin(b));
        PriorityQueue<int[]> pointsClosestToOrigin = new PriorityQueue<>(pointCompare);

        for (int[] point : points) {
            pointsClosestToOrigin.add(point);
        }
        List<int[]> kPoints = new ArrayList<>();
        while(k > 0 && !pointsClosestToOrigin.isEmpty()) {
            kPoints.add(pointsClosestToOrigin.poll());
            --k;
        }
        return kPoints.toArray(new int[kPoints.size()][]);

    }
    private double distanceFromOrigin(int[] a) {
        Double x = Double.valueOf(a[0]);
        Double y = Double.valueOf(a[1]);
        return Math.sqrt((x*x) + (y*y));
    }
}

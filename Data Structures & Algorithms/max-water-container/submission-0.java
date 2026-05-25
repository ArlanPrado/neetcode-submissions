class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length - 1;
        int max = Integer.MIN_VALUE;
        while (start != end) {
            int minHeight = Integer.compare(heights[start], heights[end]);
            int indexDifference = end - start;
            if (minHeight >= 0) {
                minHeight = heights[end];
                end--;
            } else {
                minHeight = heights[start];
                start++;
            }
            int area = indexDifference * minHeight;
            if (max < area) {
                max = area;
            }
        }
        return max;
    }
}

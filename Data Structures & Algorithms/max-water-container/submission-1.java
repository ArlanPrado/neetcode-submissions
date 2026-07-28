class Solution {
    public int maxArea(int[] heights) {
        /*
        two pointers, pointer at start and pointer at end
        between the two pointers, the one pointing to the shortest one is moving
        */
        int start = 0;
        int end = heights.length-1;
        int maxArea = 0;
        while (start < end) {
            int minHeight;
            boolean moveStart = true;
            if (heights[start] < heights[end]) {
                minHeight = heights[start];
                moveStart = true;
            } else {
                minHeight = heights[end];
                moveStart = false;
            }
            
            int tempArea = (end - start) * (minHeight);
            if (tempArea > maxArea) {
                maxArea = tempArea;
            }

            if (moveStart) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}

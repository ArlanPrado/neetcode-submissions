class Solution {
    public int findMin(int[] nums) {
        /*
        find the min by binary search
        look at the mid, if the right is more then look left, if the left less then look left
        if the left is more then you found then min and return
        if the right is less then look right
        */

        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        int endV;
        while (start < end) {
            endV = nums[end];
            int midIx = start + (end - start) / 2;
            int mid = nums[midIx];
            if (mid < min) {
                min = mid;
            }
            // if mid value is > endV then look right
            if (mid > endV) {
                start = midIx + 1;
            } else {             //if mid value is < endV then keep looking left
                 end = midIx;
            }
        }
        return min;
    }
}

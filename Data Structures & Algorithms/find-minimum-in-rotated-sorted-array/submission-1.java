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
        while (start < end) {
            int mid = start + (end - start) / 2;
            // if mid value is > endV then look right
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {             //if mid value is < endV then keep looking left
                 end = mid;
            }
        }
        return nums[start];
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 5;
        while (left < right) {
            System.out.println(left + " " + right);
            mid = ((right - left) / 2) + left;
            int midVal = nums[mid];
            if (midVal == target) {
                return mid;
            }
            if (mid+1 >= nums.length) {
                return nums.length - 1;
            }
            int midPVal = nums[mid+1];
            if (midVal <= target && midPVal >= target) {
                return mid;
            } 
            if (midVal > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }
}
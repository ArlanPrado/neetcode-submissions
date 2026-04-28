class Solution {
    public int search(int[] nums, int target) {
        /*
        binary search, start in middle then move to the left or right depending if less or greater than.
        */
        int search = -1;
        boolean stillPossibleToFind = true;
        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        do {
            index = left + (right - left) / 2;
            search = nums[index];
            if (search > target) {
                right = index - 1;
            } else if (search < target) {
                left = index + 1;
            }
            if (left > right) {
                stillPossibleToFind = false;
            }
        } while (stillPossibleToFind && search != target);
        if (!stillPossibleToFind && search != target) {
            return -1;
        }
        return index;
    }
}
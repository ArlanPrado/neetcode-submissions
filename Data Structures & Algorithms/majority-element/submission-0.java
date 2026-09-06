class Solution {
    public int majorityElement(int[] nums) {
        int minimumSize = nums.length / 2;
        int i = 0;
        Arrays.sort(nums);
        int count = 0;
        int num = 0;
        while (i < nums.length) {
            if (i == 0 || nums[i-1] != nums[i]) {
                num = nums[i];
                count = 0;
            }
            if (count >= minimumSize) {
                return num;
            }
            i++;
            count++;
        }
        return count;
    }
}
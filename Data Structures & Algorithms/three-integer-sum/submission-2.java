class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int b = i + 1;
            int c = nums.length - 1;
            while (b < c) {
                int sum = nums[i] + nums[b] + nums[c];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[b], nums[c]));
                    b++;
                    c--;
                    while (b < c && nums[b] == nums[b - 1]) b++;
                    while (b < c && nums[c] == nums[c - 1]) c++;
                }
                else if (sum < 0) {
                    b++;
                }
                else { // sum > 0
                    c--;
                }
            }
        }
        return result;
    }
}

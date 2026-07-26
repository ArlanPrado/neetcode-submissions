class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currentCombo = new ArrayList<>();
        backtrack(nums, target, 0, currentCombo, results);
        return results;
    }
    private void backtrack(int[] nums, int remain, int start, List<Integer> currentCombo, List<List<Integer>> results) {
        //base case: if the remaining is 0 then the current combo is matching the target
        if (remain == 0) {
            results.add(currentCombo);
            return;
        }

        
        for (int i = start; i < nums.length; i++) {
            int num = nums[i];

            if (num > remain) {
                continue;
            }

            currentCombo.add(num);
            backtrack(nums, remain - num, i, new ArrayList<>(currentCombo), results);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }
}

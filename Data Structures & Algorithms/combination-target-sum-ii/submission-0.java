class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> res = new ArrayList<>();
        backtrack(0, candidates, target, res);
        return result;
        
    }
    private void backtrack(int start, int[] candidates, int remain, List<Integer> res) {
        if (remain == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remain) {
                continue;
            }
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            res.add(candidates[i]);
            backtrack(i + 1, candidates, remain - candidates[i], res);
            res.removeLast();
        }
    }
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /*
        subproblem of going to 1 integer then returning the permutation of the smallest set to the total set
        */
        if (nums.length == 0) {
            return List.of(new ArrayList<>());
        }
        List<List<Integer>> result = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> newResult = new ArrayList<>();
        for (List<Integer> list : result) {
            for (int i = 0; i <= list.size(); i++) {
                List<Integer> listC = new ArrayList<>(list);
                listC.add(i, nums[0]);
                newResult.add(listC);
            }
        }
        return newResult;
    }


}

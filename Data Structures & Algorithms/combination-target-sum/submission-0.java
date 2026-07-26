class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        rec(nums, target, new Integer[0], results);
        return results;
        
    }
    private List<Integer> rec(int[] nums, int target, Integer[] potential, List<List<Integer>> results) {
        Integer diff = target;
        if (potential.length != 0) {
            List<Integer> result = Arrays.asList(potential);
            Integer combined = result.stream().reduce(0, (partialSol, element) -> partialSol + element);
            diff = target - combined;
            if (diff == 0) {
                return result;
            } else if (diff < 0) {
                return null;
            }
        }
        List<Integer> numsList = Arrays.stream(nums).boxed().toList();
        Integer diffFinal = diff;
        numsList = numsList.stream().filter(num -> num <= diffFinal).toList();
        for (Integer num : numsList) {
            Integer[] newPotential = Arrays.copyOf(potential, potential.length + 1);
            newPotential[newPotential.length-1] = num;
            List<Integer> newResult = rec(nums, target, newPotential, results);
            if (newResult != null) {
                Collections.sort(newResult);
                if (!results.contains(newResult)) {
                    results.add(newResult);
                }
            }
        }
        return null;

    }
}

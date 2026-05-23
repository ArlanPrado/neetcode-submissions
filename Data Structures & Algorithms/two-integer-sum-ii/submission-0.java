class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (null != numMap.get(diff)) {
                int[] result = {numMap.get(diff) + 1, i + 1};
                return result;
            } else {
                numMap.put(numbers[i], i);
            }
        }
        return null;
    }
}

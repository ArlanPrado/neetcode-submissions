class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // set an array at the same length, then insert the day count at each index
        int[] result = new int[temperatures.length];
        // needs a Pair to keep track of the index to get the true days between the colder and warmer temperature days
        Stack<Pair<Integer, Integer>> stackIndexToValue = new Stack<>(); 
        for (int i = 0; i < temperatures.length; i++) {
            int value = temperatures[i];
            Pair<Integer, Integer> indexToValue = new Pair<>(i, value);
            while (!stackIndexToValue.isEmpty() && stackIndexToValue.peek().getValue() < indexToValue.getValue()) {
                Pair<Integer, Integer> popped = stackIndexToValue.pop();
                result[popped.getKey()] = indexToValue.getKey() - popped.getKey();
            }
            stackIndexToValue.push(indexToValue);
            
        }
        while (!stackIndexToValue.isEmpty()) {
            Pair<Integer, Integer> popped = stackIndexToValue.pop();
            result[popped.getKey()] = 0;
        }
        return result;
    }
}

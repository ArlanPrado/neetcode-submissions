class Solution {
    public int lastStoneWeight(int[] stones) {
        int result = 0;
        for (int stone : stones) {
            result = Math.abs(result - stone);
        }
        return result;
    }
}

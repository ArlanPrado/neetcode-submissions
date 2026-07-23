class Solution {
    public int lastStoneWeight(int[] stones) {
        Integer stone1 = 0;
        PriorityQueue<Integer> stoneQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int stone : stones) {
            stoneQ.add(stone);
        }

        while (!stoneQ.isEmpty()) {
             stone1 = stoneQ.poll();
             Integer stone2 = stoneQ.poll();
             if (stone2 != null) {
                stone1 = Math.abs(stone1 - stone2);
                if (stone1 != 0) {
                    stoneQ.add(stone1);
                }
             }
        }
        return stone1;
    }
}

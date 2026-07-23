class Solution {
    public int lastStoneWeight(int[] stones) {
        // if stones is empty then just return 0, it won't reach the while loop
        Integer stone1 = 0;
        // Integer descend sort
        PriorityQueue<Integer> stoneQ = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        // add stones
        for (int stone : stones) {
            stoneQ.add(stone);
        }

        while (!stoneQ.isEmpty()) {
             stone1 = stoneQ.poll();
             Integer stone2 = stoneQ.poll();
             // if stone2 is null, then we reached the last stone and return
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

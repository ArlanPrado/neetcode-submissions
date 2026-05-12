class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        
        // Sort by position descending (closest to target first)
        Arrays.sort(idx, (a, b) -> position[b] - position[a]);
        
        int fleets = 0;
        double topOfStack = 0; // time for the leading fleet to reach target
        
        for (int i : idx) {
            double time = (double)(target - position[i]) / speed[i];
            if (time > topOfStack) {
                // This car can't catch the one ahead — it's a new fleet
                fleets++;
                topOfStack = time;
            }
            // If time <= topOfStack, it catches up and merges — not a new fleet
        }
        
        return fleets;
    }
}
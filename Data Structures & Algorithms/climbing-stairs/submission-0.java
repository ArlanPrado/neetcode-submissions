class Solution {
    
    Integer[] cache;
    public int climbStairs(int n) {
        cache = new Integer[n+1]; // stores the amount of solutions at the place
        //start at the max - 1 then go down
        int counter = 0;
        for (int i = n+1; i > 0; --i) {
            if (i + 1 == n) {
                if (cache[i+1] != null) {
                    counter += cache[i+1];
                } else {
                    ++counter;
                    cache[i] = counter;
                }
            }
            if (i + 2 == n) {
                if (cache[i+2] != null) {
                    counter += cache[i+2];
                } else {
                    ++counter;
                    cache[i] = counter;
                }
            }
        }
        for (Integer i : cache) {
            System.out.println(i);
        }

        return counter;
    }
}

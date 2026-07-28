class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
         h will only be equal to the amount of piles or greater
         the max k should be the biggest pile in the array
        */
        Arrays.sort(piles);
        int maxK = piles[piles.length - 1];
        List<Integer> ks = new ArrayList<>();
        int left = 1;
        int right = maxK;
        int minK = Integer.MAX_VALUE;
        while (left <= right) {
            int k = (left + right) / 2;
            System.out.println(k);
            // if h result from k is > input h, then look right (go higher eating rate)
            // if h result from k is <= input h, then look left (go lower eating rate) and set minK
            int hCalc = 0;
            for (int pile : piles) {
                hCalc += hoursUsed(pile, k);
                if (hCalc > h) {
                    break;
                }
            }
            if (hCalc > h) {
                left = k + 1;
            } else {
                right = k - 1;
                if (k < minK) {
                    minK = k;
                }
            }
        }
        return minK;

    }
    private int hoursUsed(int pile, int k) {
        return (pile + k - 1) / k;
    }
}

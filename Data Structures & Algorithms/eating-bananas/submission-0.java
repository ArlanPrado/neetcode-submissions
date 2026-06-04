class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        /*
        1. sort the piles
        2. get the middle amount of piles
        */
        Arrays.sort(piles);
        // middle can either be 
        boolean foundClosestToEatSpd = false;
        int left = 0;
        int right = piles.length - 1;
        int minEatSpd = Integer.MAX_VALUE;
        
        int rightHours = getHoursToEat(piles, piles[right]);
        if (rightHours <= h) {
            minEatSpd = piles[right];
        }
        // int leftHours = getHoursToEat(piles, piles[left]);
        while (left < right) {
            int mid = ((right - left) + left) / 2;
            int midVal = piles[mid];
            // eat speed algorithm to find how many hours it takes
            int hoursToEat = getHoursToEat(piles, midVal);
            // if result hours > target hours then go to the right on the array
            if (hoursToEat > h) {
                left = midVal+1;
            }
            // if result hours < target hours AND eatspd < minEatSpd 
            // then set minEatSpd AND move left
            if (hoursToEat <= h && midVal < minEatSpd) {
                minEatSpd = midVal;
                right = midVal-1;
            }
        }
        return minEatSpd;
    }
    private int getHoursToEat(int[] piles, int eatSpd) {
        int hoursToEat = 0;
        for (int pile : piles) {
            //round up function to find hours to eat
            hoursToEat += (pile + (eatSpd - 1))  / eatSpd;
        }
        return hoursToEat;
    }
}

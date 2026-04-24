class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (prices.length == 1) {
            return maxProfit;
        }
        int lowest = Integer.MAX_VALUE;
        int lowestIndex = 0;
        int highest = Integer.MIN_VALUE;
        /*
        the lowest only on left side and highest on right side must be higher than the maxProfint
        brute force: get first number, then compare it against all other numbers, this takes the longest
        memory way: 
        - after lowest has been set, then begin setting highest
        - 
        */
        
        for(int i = 0; i < prices.length; i++) {
            if (lowest > prices[i]) {
                lowest = prices[i];
                lowestIndex = i;
                highest = Integer.MIN_VALUE;
            }
            if (highest < prices[i] && lowestIndex < i) {
                highest = prices[i];
                if (highest - lowest > maxProfit) {
                    maxProfit = highest - lowest;
                }
            }
            
        }
        return maxProfit;
    }
}

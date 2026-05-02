class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<Integer> sorted = Arrays.stream(nums)
            .boxed()
            .collect(Collectors.toList());
        int longestConsecutiveTrack = 0;
        int counter = 1;
        Integer lastNumber = null;
        for(Integer num : sorted) {
            if (lastNumber != null) {
                if (num == lastNumber + 1) {
                    counter += 1;
                } else if (num != lastNumber) { 
                    if (longestConsecutiveTrack < counter) {
                        longestConsecutiveTrack = counter;
                    }
                    counter = 1;
                }
            }
            lastNumber = num;
        }
        return longestConsecutiveTrack > counter ? longestConsecutiveTrack : counter;
    }
}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length - 1;
        while( a < b ) {
            int sum = numbers[a] + numbers[b];
            if (target == sum) {
                return new int[]{a, b};
            }
            if (sum < target) {
                a++;
            } else { // sum > target
                b--;
            }
        } 
        return new int[0];
    }
}

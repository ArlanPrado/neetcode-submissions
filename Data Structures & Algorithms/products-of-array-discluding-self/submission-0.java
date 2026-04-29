class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int num = nums[j];
                    if (num == 0) {
                        product = 0;
                        break;
                    } else {
                        product*=num;
                    }
                }
            }
            result[i] = product;
        }
        return result;
    }
}  

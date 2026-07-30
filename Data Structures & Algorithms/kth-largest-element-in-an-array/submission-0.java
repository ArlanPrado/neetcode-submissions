class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for (int n : nums) {
            queue.add(n);
        }
        int kth = 0; 
        while (k > 0) {
            --k;
            kth = queue.poll();
        }
        return kth; 
    }
}

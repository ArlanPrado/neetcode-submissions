class KthLargest {
    int k; //position with the largest;
    ArrayList<Integer> numList; // stream of nums
    int kVal;
    /**
    Simply initialize and trust the k given is the correct value;
    */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        numList = new ArrayList<>();
        kVal = Integer.MIN_VALUE;
        if (nums != null && nums.length > 0) {
            numList = Arrays.stream(nums).boxed()
                            .collect(Collectors.toCollection(ArrayList::new));
            numList.sort(Collections.reverseOrder());
            if (numList.size() >= k) {
                numList = new ArrayList<>(numList.subList(0, k));
                kVal = numList.get(k - 1);
            }
        }
    }
    
    public int add(int val) {
        if (kVal >= val) {
            return kVal;
        }
        numList.add(val);
        numList.sort(Collections.reverseOrder());
        numList = new ArrayList<>(numList.subList(0, k));
        kVal = numList.get(k - 1);
        return kVal;
    }
        
}

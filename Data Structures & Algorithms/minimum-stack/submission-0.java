class MinStack {

    List<Integer> stack;
    Integer minVal;

    public MinStack() {
        stack = new ArrayList<>();
        minVal = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        stack.addLast(val);
        if (minVal > val) {
            minVal = val;
        }
    }
    
    public void pop() {
        int popped = stack.removeLast();
        if (popped == minVal) {
            minVal = Integer.MAX_VALUE;
            for (int val : stack) {
                if (minVal > val) {
                    minVal = val;
                }
            }
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minVal;
    }
}

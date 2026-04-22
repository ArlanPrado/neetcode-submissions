class DynamicArray {

    Integer[] array;
    int capacity;
    int size;
    public DynamicArray(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("bad size");
            this.array = new Integer[capacity];
            this.capacity = capacity;
            size = 0;
 
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if (size == capacity){
            resize();
        }
        array[size] = n;
        size++;
    }

    public int popback() {
        if (size == 0) throw new IllegalStateException("empty");
        int val = array[size - 1];
        array[size - 1] = null; // optional
        size--;
        return val;

    }

    private void resize() {
        Integer[] newArray = new Integer[capacity*2];
        int iter = 0;
        while(iter < size) {
            newArray[iter] = array[iter];
            iter++;
        }
        array = newArray;
        capacity = capacity*2;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}

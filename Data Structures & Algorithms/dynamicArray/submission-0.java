class DynamicArray {

    Integer[] array;
    int capacity;
    int size;
    public DynamicArray(int capacity) {

            this.array = new Integer[capacity];
            this.capacity = capacity;
 
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
        size += 1;
    }

    public void pushback(int n) {
        int iter = capacity-1;
        while (array[iter] != null) {
            iter++;
        }
        if (iter > 0) {
            array[iter] = n;
            size += 1;
        }
    }

    public int popback() {
        size -= 1;
        return array[capacity-1];

    }

    private void resize() {
        Integer[] newArray = new Integer[capacity*2];
        int iter = 0;
        while(iter <= capacity) {
            newArray[iter] = array[iter];
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

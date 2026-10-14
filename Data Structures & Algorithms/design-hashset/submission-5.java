class MyHashSet {

    int[] set;

    public MyHashSet() {
        set = new int[0];
    }
    
    public void add(int key) {
        if (!contains(key)) {
            int[] newSet = new int[set.length+1];
            for(int i = 0; i < set.length; i++) {
                newSet[i] = set[i];
            }
            newSet[set.length] = key;
            set = newSet;
        }
    }
    
    public void remove(int key) {
        if (!contains(key)) {
            return;
        }

        int[] newSet = new int[set.length-1];
        int counter = 0;
        for(int i = 0; i < set.length; i++) {
            if (set[i] == key) {
                continue;
            }
            newSet[counter] = set[i];
            counter++;
        }
        set = newSet;
    }
    
    public boolean contains(int key) {
        boolean c = false;
        for (int i : set) {
            if (i == key) {
                c = true;
                break;
            }
        }
        return c;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
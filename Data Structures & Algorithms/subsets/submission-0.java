class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // result.add(new ArrayList<>());
        // if (nums.length == 0) {
        //     return result;
        // }

        /*
        thinking of a function, given a number, gets the possible combinations from that number..  
        0: []
        1: gets 1 number from the array..       this will have the most elements, so this will be nums.length
        2: gets 2 numbers from the array..      
            starts with 1 index, loops for each index not the 1 selected and returns each
        n.size: gets n numbers from the array / returns the whole list

        */




        return result;
    }
    private List<List<Integer>> subset(int[] nums, int count) {
        List<Integer> indexes = new ArrayList<Integer>();

        // start a list of indexes 0 to n (n being the count - 1) if count > nums.length its not valid
        // keep increasing right count until it hits nums.length
        // once it hits nums.length, then increase the index to the left by 1 and start again from the number on the right
        // this will keep going through every permutation, sort of like binary
    
    }
}

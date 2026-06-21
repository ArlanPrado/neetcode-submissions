// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return List.of();
        }
        int pointer = 1;
        int start = 0;
        List<List<Pair>> result = new ArrayList<>();
        while (pointer < pairs.size()) {
            result.add(new ArrayList<>(pairs));
            Pair pointed = pairs.get(pointer);
            while (start < pointer) {
                Pair lookSorted = pairs.get(start);
                if (pointed.key < lookSorted.key) {
                    // 1. Remove the element from its current position
                    pairs.remove(pointer);
                    // 2. Insert it at the correct sorted position
                    // (This automatically shifts 'lookSorted' and everything else to the right)
                    pairs.add(start, pointed);
                    break;
                }
                ++start;
            }
            start = 0;
            ++pointer;
        }
        result.add(new ArrayList<>(pairs));
        return result;
    }
}

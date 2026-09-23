class Solution {
    public int calPoints(String[] operations) {
        List<Integer> s = new ArrayList<>();
        for (String op : operations) {
            if (op.equals("+")) {
                int val1 = s.get(0);
                int val2 = s.get(1);
                s.addFirst(val1+val2);
            } else if (op.equals("C")) {
                s = pop(s);
            } else if (op.equals("D")) {
                int val1 = s.getFirst();
                s.addFirst(val1 * 2);
            } else {
                Integer num = Integer.valueOf(op);
                s.addFirst(num);
            }
        }
        return s.stream().reduce((v1,v2) -> v1+v2).get();
    }

    private List<Integer> pop(List<Integer> s) {
        return s.subList(1, s.size());
    }
    
}
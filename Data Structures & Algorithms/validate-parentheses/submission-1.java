class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for( char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } else if (c == ')' && stack.removeLast() != '(') {
                return false;
            } else if (c == ']' && stack.removeLast() != '[') {
                return false;
            } else if (c == '}' && stack.removeLast() != '{') {
                return false;
            } 
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

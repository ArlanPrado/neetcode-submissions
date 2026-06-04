class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for( char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } 
            if (stack.size() > 0) {
                if (c == ')' && stack.removeLast() != '(') {
                    return false;
                } 
                if (c == ']' && stack.removeLast() != '[') {
                    return false;
                } 
                if (c == '}' && stack.removeLast() != '{') {
                    return false;
                } 
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}

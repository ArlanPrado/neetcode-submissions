class Solution {
    public boolean isValid(String s) {
        List<Character> stack = new ArrayList<>();
        for( char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.addLast(c);
            } else {
                if (checkCloseBrackets(c, ')', '(', stack)) {
                    return false;
                } 
                if (checkCloseBrackets(c, ']', '[', stack)) {
                    return false;
                } 
                if (checkCloseBrackets(c, '}', '{', stack)) {
                    return false;
                } 
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    private boolean checkCloseBrackets(char input, char close, char open, List<Character> stack) {
        return input == close && (stack.isEmpty() || stack.removeLast() != open);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<>();
        for (String str : tokens) {
            try {
                Integer num = Integer.parseInt(str);
                rpnStack.push(num);
            } catch (NumberFormatException nfe) {
                Integer num1 = rpnStack.pop();
                Integer num2 = rpnStack.pop();
                switch(str) {
                    case "+" :
                        rpnStack.push(num1 + num2);
                        break;
                    case "-" :
                        rpnStack.push(num1 - num2);
                        break;
                    case "*" :
                        rpnStack.push(num1 * num2);
                        break;
                    case "/": 
                        rpnStack.push(num1 / num2);
                        break;
                }
            }
        }
        return rpnStack.pop();
    }
}

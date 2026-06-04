class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) {
            return null;
        }
        String encoded = "";
        for (String str : strs) {
            char[] thechars = str.toCharArray();
            encoded += "#" + str.length();
            for(char thechar : thechars) {
                encoded += thechar;
            }
        }
        return encoded;
    }

    public List<String> decode(String str) {
        if (null == str ) {
            return Collections.emptyList();
        }
        if (str.equals("")) {
            return List.of(str);
        }
        char[] thechars = str.toCharArray();
        List<String> decoded = new ArrayList<>();
        int foundLengthFlag = 0; //0 not found, 1 maybe found, 2 confirmed start counting
        int counter = -1;
        String test = "";
        for(char thechar : thechars) {
            if(counter == 0) {
                decoded.addLast(test);
                test = "";
                foundLengthFlag = 0;
                counter = -1;
            } else if (counter > 0) {
                test += thechar;
                --counter;
            }
            if (thechar == '#') {
                foundLengthFlag = 1;
            } else if (foundLengthFlag == 1 && Character.isDigit(thechar)) {
                counter = thechar - '0';
                foundLengthFlag = 2;
            }
        }
        decoded.addLast(test);
        return decoded;
    }
}

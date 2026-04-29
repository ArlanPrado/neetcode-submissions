class Solution {

    public String encode(List<String> strs) {
        if (strs == null) {
            return null;
        }
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        if (null == str ) {
            return null;
        }
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int sharpIndex = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, sharpIndex));
            i = sharpIndex + 1;
            decoded.add(str.substring(i, i + length));
            i += length;
        }
        return decoded;
    }
}
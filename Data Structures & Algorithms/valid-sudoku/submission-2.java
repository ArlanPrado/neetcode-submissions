class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Character>> columnMap = new HashMap<>();
        int rowTracker = 0;

        /*
        To check squares its a 3x3 grid, it would be 0-2 column and 0-2 row. 
        Maybe just go by the top left corner and have an algorithm to calculate if its a part of a particular square.
        0x0 is square 1, 3x0 is a square 2, 6x0 is square 3, 0x3 square 4
        column-(column % 3) x row-(row % 3) gives the square it belongs.
        */
        Map<String, List<Character>> squareMap = new HashMap<>();
        for (char[] row : board) {
            List<Character> rowList = new ArrayList<>();
            for (int column = 0; column < row.length; column++) {
                char value = row[column];
                if (value != '.') {
                    if (rowList.contains(value)){
                        return false;
                    } 
                    rowList.add(value);
                    // get the column list by number, if the column list exists, then check if number exists in list and return false
                    // if the column list doesn't exist then create a new list
                    List<Character> columnChars = columnMap.get(column);
                    if (null == columnChars) {
                        columnMap.put(column, new ArrayList<Character>(List.of(value)));
                    } else {
                        if (columnChars.contains(value)) {
                            return false;
                        }
                        columnChars.add(value);
                        columnMap.put(column, columnChars);
                    }
                    String leadingSquare = getSquare(column, rowTracker);
                    List<Character> squareChars =  squareMap.get(leadingSquare);
                    if (null == squareChars) {
                        squareMap.put(leadingSquare, new ArrayList<Character>(List.of(value)));
                    } else {
                        if (squareChars.contains(value)) {
                            return false;
                        }
                        squareChars.add(value);
                        squareMap.put(leadingSquare, squareChars);
                    }
                }
            }
            ++rowTracker;
        }
        return true;
    }
    private String getSquare(Integer column, Integer row) {
        return (column-(column % 3)) + "x" + (row-(row % 3));
    }
}

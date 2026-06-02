class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
        Strategy look at the first index of the row until we the target <= matrix[?][0]
        Once the condition is found then return true if target == matrix[?][0] 
            else go back to the previous list then go to the middle index. matrix[?-1][matrix.length/2]
                if the target < middle value then look left, else look right, if == then return true
        If the condition is never found then go to the middle index. matrix[?-1][matrix.length/2]
                if the target < middle value then look left, else look right, if == then return true
        If reached to the matrix[?][row.length] or matrix[?][0] then return false;
        */
        
        if (matrix[0].length == 0) {
            return false;
        }
        // find row
        int[] row = null;
        for (int i = 0; i < matrix.length; i++) {
            if (target == matrix[i][0]) {
                return true;
            }
            else if (target < matrix[i][0] && i > 0) {
                if (i - 1 < 0) {
                    return false;
                }
                row = matrix[i - 1];
                break;
            } 
        }
        if (row == null) {
            row = matrix[matrix.length - 1];
        }

        // binary search
        boolean stillPossibleToFind = true;
        int leftIndex = 0;
        int rightIndex = row.length - 1;
        while (leftIndex <= rightIndex) {
            int leftVal = row[leftIndex];
            int rightVal = row[rightIndex];
            if (leftVal == target || rightVal == target) {
                return true;
            }
            
            int middleIndex = ((rightIndex - leftIndex) / 2) + leftIndex;
            int middleVal = row[middleIndex];

            if (middleVal == target) {
                return true;
            }

            if (middleVal > target) {
                leftIndex = leftIndex + 1;
                rightIndex = middleIndex - 1;
            } else {
                leftIndex = middleIndex + 1;
                rightIndex = rightIndex - 1;
            }
        }
        return false;
    }
    // Solution is O(m + log(n)) because it iterates through the whole list of rows then binary searches on columns,
    // Better solution would to do binary search on the row as well to get O(log(m * n))
}

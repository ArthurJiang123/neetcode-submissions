class Solution {
    // Time: O(log(m)+log(n) = log(m*n)), Space: O(1)
    // Binary search the sorted rows. Each each row is sorted [first, last]
    //  - midRow's last < target → row and above are too small → topRow = midRow+1
    //  - midRow's first > target → row and below are too large → btmRow = midRow-1
    //  - else target lies in this row → binary search it.
    public boolean searchMatrix(int[][] matrix, int target) {

        int topRow = 0, btmRow = matrix.length - 1;
        int leftCol = 0, rightCol = matrix[0].length - 1;
        int midRow = 0;

        while (topRow <= btmRow) {
            midRow = (topRow + btmRow) / 2;
            if (matrix[midRow][rightCol] < target) {
                topRow = midRow + 1;
            } else if (matrix[midRow][leftCol] > target) {
                btmRow = midRow - 1;
            } else {
                break;
            }
        }
        // topRow > btmRow means the break condition is never reached,
        // meaning target is outside all the row ranges.
        if (topRow > btmRow) return false;

        int midCol;
        while (leftCol <= rightCol) {
            midCol = (leftCol + rightCol) / 2;
            if (matrix[midRow][midCol] < target) {
                leftCol = midCol + 1;
            } else if (matrix[midRow][midCol] > target) {
                rightCol = midCol - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}

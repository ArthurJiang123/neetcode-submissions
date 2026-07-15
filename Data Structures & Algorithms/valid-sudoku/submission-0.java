class Solution {
    
    public boolean isValidSudoku(char[][] board) {
        
        Set<Character>[] rowSets = new HashSet[9];
        Set<Character>[] colSets = new HashSet[9];
        Set<Character>[] boxSets = new HashSet[9];

        for(int i = 0; i < 9; i++){
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        for(int rowId = 0; rowId < board.length; rowId++){
            for(int colId = 0; colId < board.length; colId++){
                char cell = board[rowId][colId];
                
                if (cell == '.') continue;

                Set<Character> rowSet = rowSets[rowId];
                Set<Character> colSet = colSets[colId];
                int boxSetId = (rowId/3)*3 + (colId/3);
                Set<Character> boxSet = boxSets[boxSetId];

                if(rowSet.contains(cell)
                || colSet.contains(cell)
                || boxSet.contains(cell)){
                    return false;
                }
                rowSet.add(cell);
                colSet.add(cell);
                boxSet.add(cell);
            }
        }
        return true;

    }
}

class Solution {
    boolean checkRow(char[][] board, int row) {
        Set<Character> set = new HashSet<>();
        for (char c: board[row]) {
            if (c == '.') {
                continue;
            }
            
            if (c < '1' || c > '9') {
                return false;
            }
            
            if (set.contains(c)) {
                return false;
            }
            
            set.add(c);
        }
        
        return true;
    }
    
    boolean checkCol(char[][] board, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            char c = board[i][col];
            if (c == '.') {
                continue;
            }
            
            if (set.contains(c)) {
                return false;
            }
            
            set.add(c);
        }
        
        return true;  
    }
    
    boolean checkBox(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; ++i) {
            for (int j = col; j < col + 3; ++j) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (set.contains(c)) {
                    return false;
                }
            
                set.add(c);
            }
        }
        
        return true; 
    }
    
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            if (!checkRow(board, i)) {
                return false;
            }
        }
        
        for (int j = 0; j < board[0].length; ++j) {
            if (!checkCol(board, j)) {
                return false;
            }
        }
        
        for (int i = 0; i <= board.length - 3; i += 3) {
            for (int j = 0; j <= board[0].length - 3; j += 3) {
                if (!checkBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

class Solution {
    boolean isSurroundewd(char[][] board, int row, int col) {
        if (board[row][col] == 'X')
            return true;

        if (row == 0 || col == 0 || row == board.length - 1|| col == board[0].length - 1) {
            return false;
        }
        
        board[row][col] = 'T';

        if (board[row-1][col] == 'O' && !isSurroundewd(board, row - 1, col))
            return false;
        if (board[row+1][col] == 'O' && !isSurroundewd(board, row + 1, col))
            return false;
        if (board[row][col-1] == 'O' && !isSurroundewd(board, row, col-1))
            return false;
        if (board[row][col+1] == 'O' && !isSurroundewd(board, row, col+1))
            return false;
        
        return true;
    }
    
    void flip(char[][] board, int row, int col) {
        if (board[row][col] == 'X')
            return;
        board[row][col] = 'X';
        if (row > 0)
            flip(board, row - 1, col);
        if (row < board.length - 1)
            flip(board, row + 1, col);
        if (col > 0)
            flip(board, row, col - 1);
        if (col < board[0].length - 1)
            flip(board, row, col + 1);
    }
    
    void populateS(char[][] board, int row, int col) {
        if (board[row][col] == 'X')
            return;
        board[row][col] = 'S';
        if (row > 0 && board[row-1][col] != 'S')
            populateS(board, row - 1, col);
        if (row < board.length - 1 && board[row+1][col] != 'S')
            populateS(board, row + 1, col);
        if (col > 0 && board[row][col - 1] != 'S')
            populateS(board, row, col - 1);
        if (col < board[0].length - 1 && board[row][col + 1] != 'S')
            populateS(board, row, col + 1);
    }
    
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] == 'O' && isSurroundewd(board, i, j)) {
                    flip(board, i, j);
                } else if (board[i][j] == 'O' || board[i][j] == 'T') {
                    populateS(board, i, j);
                }
            }
        }
        
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                if (board[i][j] != 'X') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

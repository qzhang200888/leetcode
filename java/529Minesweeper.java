class Solution {
    
    int adjacentMines(char[][] board, int r, int c) {
        int count = 0;
        if (r > 0) {
            if (board[r-1][c] == 'M' || board[r-1][c] == 'X')
                ++count;
            if (c > 0 && (board[r-1][c-1] == 'M' || board[r-1][c-1] == 'X'))
                ++count;
            if (c < board[0].length - 1 && (board[r-1][c+1] == 'M' || board[r-1][c+1] == 'X'))
                ++count;
        }
        
        if (r < board.length - 1) {
            if (board[r+1][c] == 'M' || board[r+1][c] == 'X')
                ++count;
            if (c > 0 && (board[r+1][c-1] == 'M' || board[r+1][c-1] == 'X'))
                ++count;
            if (c < board[0].length - 1 && (board[r+1][c+1] == 'M' || board[r+1][c+1] == 'X'))
                ++count;
        }
        
        if (c > 0 && (board[r][c-1] == 'M' || board[r][c-1] == 'X'))
            ++count;
        if (c < board[0].length - 1 && (board[r][c+1] == 'M' || board[r][c+1] == 'X'))
            ++count;
        
        return count;
    }
        
    
    void update(char[][] board, int r, int c) {
        if (r < 0 || c < 0)
            return;
        if (r >= board.length || c >= board[0].length)
            return;
        
        if (board[r][c] == 'E') {
            int count = adjacentMines(board, r, c);
            if (count > 0)
                 board[r][c] = (char)('0' + count);
            else {
                board[r][c] = 'B';

                update(board, r-1, c);
                update(board, r-1, c-1);
                update(board, r-1, c+1);
                
                update(board, r, c-1);
                update(board, r, c+1);
                
                update(board, r+1, c);
                update(board, r+1, c-1);
                update(board, r+1, c+1);
            }
        }
    }
    
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click.length == 0)
            return board;

        int r = click[0];
        int c = click[1];
        
        if (board[r][c] == 'M') {
            board[r][c] = 'X';
            return board;
        }
        
        update(board, r, c);
        
        return board;
    }
}

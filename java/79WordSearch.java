class Solution {
    private boolean exist(char[][] board, String word, int i, int j, int pos,
                         boolean[][] visited) {
        if (pos == word.length())
            return true;
        if (i < 0 || j < 0)
            return false;
        if (i >= board.length || j >= board[0].length)
            return false;
        if (visited[i][j])
            return false;
        if (board[i][j] != word.charAt(pos))
            return false;
        
        visited[i][j] = true;
        
        boolean ret = false;
        
        if (exist(board, word, i + 1, j, pos + 1, visited) ||
            exist(board, word, i - 1, j, pos + 1, visited) ||
            exist(board, word, i, j + 1, pos + 1, visited) ||
            exist(board, word, i, j - 1, pos + 1, visited))
            ret = true;
        
        visited[i][j] = false;
        
        return ret;
    }
    
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null ||
            board.length == 0 || board[0].length == 0)
            return false;
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                visited[i][j] = false;
        
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j)
                if (exist(board, word, i, j, 0, visited))
                    return true;
                    
        return false;
    }
}

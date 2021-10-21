class Solution {
    /*
        Time Complexity: O(N⋅ 3^L) where NN is the number of cells in the board and LL is the length of the word to be matched.

        For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L

        We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.

        As a result, overall the time complexity of the algorithm would be O(N⋅3^L).

        Space Complexity: O(L) where L is the length of the word to be matched.

        The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is O(L).
    */
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j]==word.charAt(0) && searchWord(i, j, 0, word, board)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean searchWord(int i, int j, int index, String word, char[][] board){
        if(index == word.length())
            return true;
        
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || word.charAt(index)!=board[i][j] || visited[i][j]) {
            return false;
        }
        
        visited[i][j] = true;
        
        if (searchWord(i-1, j, index+1, word, board)||
            searchWord(i+1, j, index+1, word, board)||
            searchWord(i, j-1, index+1, word, board)||
            searchWord(i, j+1, index+1, word, board)) {
            return true;
        }
        
        visited[i][j]=false;
        return false;
    }
}
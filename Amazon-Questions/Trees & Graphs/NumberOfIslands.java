class Solution {
    // DFS
    // Time: O(M x N) (M = rows, N = columns) (O(N^2) for a square grid)
    // pace complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
    public int numIslands(char[][] grid) {
        
        int numIslands = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j]=='1') {
                    numIslands++;
                    BFS(grid, i, j);   
                }
            }
        }
        return numIslands;
    }
    
    public void BFS(char[][] grid, int i, int j) {
        //check edge cases
        if (i>=grid.length || i<0 || j>=grid[i].length || j<0 || grid[i][j]=='0') {
            return;
        }
        grid[i][j] = '0';
        
        BFS(grid, i+1, j); //right
        BFS(grid, i-1, j); //left 
        BFS(grid, i, j+1); //down 
        BFS(grid, i, j-1); //up
        return;
    }
}
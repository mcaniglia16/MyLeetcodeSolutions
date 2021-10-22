class Solution {
    /*
        O(N) time
        O(N) space
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    public void dfs(int[][] image, int i, int j, int color, int newColor) {
        if (i >  image.length-1 || i < 0 || j > image[i].length-1 || j < 0 || image[i][j] != color) {
            return;
        }
        image[i][j] = newColor;
        
        dfs(image, i-1, j, color, newColor);
        dfs(image, i+1, j, color, newColor);
        dfs(image, i, j-1, color, newColor);
        dfs(image, i, j+1, color, newColor);
        return;
    }
}
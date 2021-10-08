class Solution {
    public void rotate(int[][] matrix) {
        
        //Step 1: transpose the matrixs
        for (int i=0; i<matrix.length; i++) {
            //YOU NEED TO MAKE j START AT i IF NOT IT WILL SWITCH THE ENTRIES MORE THAN ONCE AND WILL NOT TRANSPOSE
            for (int j=i; j<matrix[i].length; j++) {
                if ( i!=j ) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
        //Step 2: invert every row in the matrix using 2 pointers
        for (int i=0; i<matrix.length; i++) {
            int left = 0;
            int right = matrix[i].length-1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                right--;
                left++;
            }
        }
    }
}
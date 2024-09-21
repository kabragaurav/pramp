/*
Matrix Spiral Copy
Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array in a spiral order, clockwise. Your function then should return that array. Analyze the time and space complexities of your solution.

Example:

input:  inputMatrix  = [ [1,    2,   3,  4,    5],
                         [6,    7,   8,  9,   10],
                         [11,  12,  13,  14,  15],
                         [16,  17,  18,  19,  20] ]

output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
Constraints:

[time limit] 5000ms

[input] array.array.integer inputMatrix

1 ≤ inputMatrix[0].length ≤ 100
1 ≤ inputMatrix.length ≤ 100
[output] array.integer

@author gauravkabra
@since 2024
 */

class MatrixSpiralCopy {

  static int[] spiralCopy(int[][] matrix) {
    int M = matrix.length;
        int N = matrix[0].length;
        
        int[] ls = new int[M*N];
        int index = 0;
        
        int dir = 0;
        int row1 = 0, row2 = M-1;
        int col1 = 0, col2 = N-1;
        
        while (row1 <= row2 && col1 <= col2) {
        switch (dir) {
            case 0: 
                for (int j=col1; j<=col2; j++)
                    ls[index++] = matrix[row1][j];
                row1++;
                break;
            case 1: 
                for (int i=row1; i<=row2; i++)
                    ls[index++] = matrix[i][col2];
                col2--;
                break;
            case 2: 
                for (int j=col2; j>=col1; j--)
                    ls[index++] = matrix[row2][j];
                row2--;
                break;
            default: 
                for (int i=row2; i>=row1; i--)
                    ls[index++] = matrix[i][col1];
                col1++;
                break;
        }
            
            dir = ++dir % 4;
        }
        
        return ls;
  }

  public static void main(String[] args) {
    // debug your code below
    int[][] inputMatrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[] result = spiralCopy(inputMatrix);
    for (int num : result) {
        System.out.print(num + " ");
    }
  }
}
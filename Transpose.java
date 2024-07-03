package Matrix;

import java.util.Scanner;

public class Transpose {
    // Finds transpose of A[][] in-place 
    static void transpose_inplace(int A[][]) 
    { 
        //works with only square matrix
        for (int i = 0; i < A.length; i++) 
            for (int j = i + 1; j < A.length; j++) { 
                int temp = A[i][j]; 
                A[i][j] = A[j][i]; 
                A[j][i] = temp; 
            } 
    }
     static public int[][] transpose(int[][] matrix) {
        //using aditional matrix to solve
        //works for both sqaure and rectangular matrix
        int transpose[][] = new int[matrix[0].length][matrix.length];
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length; j++){
                transpose[i][j] = matrix[j][i];
            }
        }

        return transpose;

    }

    static void display(int[][] m){
        System.out.println("Matrix");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and cols: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] matrix = new int[n][m];
        System.out.println("Enter matrix elements");

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        matrix = transpose(matrix);
        display(matrix);
        sc.close();
}
}
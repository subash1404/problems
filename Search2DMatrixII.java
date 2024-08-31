import java.util.Scanner;

public class Search2DMatrixII {
    static public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int row = 0, col = matrix[0].length - 1;
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }
        System.out.println(searchMatrix(arr, target));
        sc.close();
    }
}

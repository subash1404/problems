import java.util.Scanner;

public class SetMatrixZeros {
    static public void setZeroes(int[][] arr) {
        boolean col0 = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0) {
                        arr[0][j] = 0;
                    } else {
                        col0 = true;
                    }
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if (arr[i][0] == 0 || arr[0][j] == 0) {
                    arr[i][j] = 0;
                }
            }
        }
        if (arr[0][0] == 0) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[0][j] = 0;
            }
        }
        if (col0) {
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = 0;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }
        setZeroes(arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        sc.close();
    }
}

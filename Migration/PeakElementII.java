package Migration;
import java.util.Scanner;

public class PeakElementII {
    public static int findMax(int[][] arr, int mid, int n) {
        int max = Integer.MIN_VALUE;
        int row = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                row = i;
            }
        }
        return row;
    }

    public static int[] findPeakGrid(int[][] mat) {
        //  Find the middle column and find the largest value in that column
        //  Compare the larger value in the column with the left and right values
        int m = mat.length, n = mat[0].length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = findMax(mat, mid, m);
            int max = mat[row][mid];
            int left = mid - 1 >= 0 ? mat[row][mid - 1] : -1;
            int right = mid + 1 < n ? mat[row][mid + 1] : -1;
            if (max > right && max > left) {
                return new int[] { row, mid };
            } else if (max < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return new int[] { -1, -1 };
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
        System.out.println(findPeakGrid(arr));
        sc.close();
    }
}

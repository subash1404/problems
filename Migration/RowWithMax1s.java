package Migration;
import java.util.Scanner;

public class RowWithMax1s {
    static public int countOnes(int arr[]) {
        int low = 0, high = arr.length - 1;
        int count = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == 1) {
                count = arr.length - mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return count;
    }

    static public int rowWithMax1s(int arr[][]) {
        int max = 0, row = -1;
        for (int i = 0; i < arr.length; i++) {
            int count = countOnes(arr[i]);
            if (count > max) {
                max = count;
                row = i;
            }
        }
        return row;
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
        int ans = rowWithMax1s(arr);
        System.out.println(ans);
        sc.close();
    }
}

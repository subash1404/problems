import java.util.Scanner;

public class MedianMatrix {
    public static int findSmaller(int[][] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int low = 0, high = arr[0].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (arr[i][mid] <= x) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }

    public static int median(int arr[][], int m, int n) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (arr[i][0] < low)
                low = arr[i][0];
            if (arr[i][n - 1] > high)
                high = arr[i][n - 1];
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int midIndex = (m * n) / 2;
            int smallerEqulas = findSmaller(arr, mid);
            if (smallerEqulas <= midIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
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
        System.out.println(median(arr,arr.length,arr[0].length));
        sc.close();
    }
}

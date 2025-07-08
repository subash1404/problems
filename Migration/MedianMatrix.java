package Migration;
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
        // As the rows are sorted get the largest and smallest value from comparing the first and last elements of each row
        for (int i = 0; i < m; i++) {
            if (arr[i][0] < low)
                low = arr[i][0];
            if (arr[i][n - 1] > high)
                high = arr[i][n - 1];
        }
        while (low <= high) {
            // Calculate the middle value of low and high and this value need not exist in the matrix initially
            // We are gonna check only the number of entries in the matrix that are less than or equal to the given mid value
            // 1 2 4
            // 5 9 10
            // 12 13 15
            // In this example the mid first is calculated to 8 which does not exisit in the matrix and smallerEquals value is also equal to 4
            // But the low is adjusted to mid+1 (9) and high is in 15 and the mid becomes 12 so smallerEquals = 7
            // Since smallerEquals >= (m*n)/2 the low is kept at 9 and high is moved to mid-1 (11) then the mid is 10 so smallerEquals is 6
            // Since smallerEquals >= (m*n)/2 the low is kept at 9 and high is moved to
            // mid-1 (9) then the mid is 9 so smallerEquals is 5
            
            int mid = (low + high) / 2;
            int midIndex = (m * n) / 2;
            System.out.println("lmid: " + low + " " +  mid + " " + high);
            System.out.println("here: " + mid + " " + midIndex);
            int smallerEquals = findSmaller(arr, mid);
            System.out.println("Smaller equals: " + smallerEquals);
            if (smallerEquals <= midIndex) {
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

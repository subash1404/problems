import java.util.Scanner;

public class OccInSortedArray {
    static int count(int[] arr, int n, int x) {
        int low = 0, high = n - 1, count = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                int index = mid;
                while (index >= 0 && arr[index] == x) {
                    count++;
                    index--;
                }
                index = mid + 1;
                // if(mid+1 != n) index = mid+1;
                // else return count;
                while (index < n && arr[index] == x) {
                    count++;
                    index++;
                }
                return count;
            } else if (arr[mid] < x)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return count;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(count(arr,n,x));
}
}

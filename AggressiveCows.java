import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static boolean isPossible(int[] arr,int n,int dist){
        int i=0,j=1;
        while (j < arr.length) {
            if(arr[j] - arr[i] >= dist ){
                n--;
                i = j;
                j++;
            }else{
                j++;
            }
        }
        return n <=1;
    }
    public static int findMinDist(int[] arr,int n){
        Arrays.sort(arr);
        int low = 1,high = arr[arr.length-1];
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if(isPossible(arr, n, mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Min Distance :"+findMinDist(arr, x));
    }
    
    // public static void main(String[] args) {
    //     Scanner sc = new Scanner(System.in);
    //     int times = sc.nextInt();
    //     for(int j=0;j<times;j++){
    //         int x = sc.nextInt();
    //         int n = sc.nextInt();
    //         int[] arr = new int[n];
    //         for (int i = 0; i < n; i++) {
    //             arr[i] = sc.nextInt();
    //         }
    //         System.out.println(findMinDist(arr, x));
    //     }
    // }
}

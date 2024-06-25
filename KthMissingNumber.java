import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthMissingNumber {
    static public int findKthPositive(int[] arr, int k) {
        List<Integer> nums = new ArrayList<>();
        int count =0;
        for(int i : arr){
            nums.add(i);
        }
        for(int i=1;i<=arr[arr.length-1]+k;i++){
            if(!nums.contains(i)) count++;
            if(count == k) return i;
        }
        return -1;
    }
    // Better soln
    static public int findKthPositive2(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k)
                k++;
            else
                break;
        }
        return k;
    }
    // Optimal(BS)
    static public int findKthPositive3(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //Formula to find the no of missing elemnts at a particular index
            int missing = arr[mid] - (mid + 1);
            // If the no of missing elements at the mid is < k eliminate the left part
            if (missing < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        // High will eventually go before low at one point
        // High and low will be at adjacent indices
        // return and using this (kind of a formula)
        return k + high + 1;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(findKthPositive(arr,x));
    System.out.println(findKthPositive2(arr,x));
    System.out.println(findKthPositive3(arr,x));
}
}

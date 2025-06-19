package Migration;
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
    // If the arr is [5 6 8 9] , k=4, we can say that the kth missing number is 4
    // In the same case where k=5, we cant say 5 because it is already present in the array, so we increment k by 1 if there is a element present in the array
    // If there is a element present k+1 could be my possible answer and i keep on incrementing
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
        // High and low will be at adjacent indices and the kth missing number will be between those low and high
        // Eg: [2 3 4 7 11] , k=5, low = 11 ,high = 7   
        // return using this (kind of a formula)

        // Explanation for the formula, we can say that arr[high] + more (which is 2 in this case, becasue three numbers were missing at high)
        // the more count is nothing but k- missing elements at arr[high]
        // missing elements at arr[high] = arr[high] - (high+1)
        // sub the more => arr[high] + k - arr[high] + high + 1  => k + high + 1
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

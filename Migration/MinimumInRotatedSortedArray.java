package Migration;
import java.util.Scanner;

public class MinimumInRotatedSortedArray {
    static public int findMin(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[0];
    }
    static int findMin2(int[] arr){
        int low = 0,high=arr.length-1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(arr[low] <= arr[high]){
                ans = Math.min(ans, arr[low]); // store the minimum value in the ans and break
                break;
            }else if(arr[low] <= arr[mid]){ // left part is sorted, eliminate the left part
                ans = Math.min(ans, arr[low]); // keep the minimum
                low = mid+1;
            }
            else{ // right part is sorted and keep the minimum
                ans = Math.min(ans, arr[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(findMin(arr));
    System.out.println(findMin2(arr));
}
}

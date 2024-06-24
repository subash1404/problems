import java.util.Scanner;

public class SingleElemInSortedArray {
    static public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return Integer.MIN_VALUE;
    }
    static int singleNonDuplicate2(int[] arr){
        int n = arr.length;
        if(n == 1) return arr[0];
        if(arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int low = 1,high=n-2;
        while (low<=high) {
            int mid = low + (high-low) / 2;
            if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) return arr[mid];
            else if((mid % 2 == 1 && arr[mid] == arr[mid-1]) || (mid%2 == 0 && arr[mid] == arr[mid+1]))
                low = mid+1;
            // we are int the left half and we have to eliminate the left half
            // refer strivers image
            else
                high = mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicate2(arr));
    }
    
}   



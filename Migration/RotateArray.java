package Migration;
import java.util.*;
public class RotateArray {
    static public void reverse(int[] arr, int li, int ri) {
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }

    static public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k < 0) {
            k += nums.length;
        }
        int partIndex = nums.length - k - 1; // for right rotation
        // int partIndex = k - 1; for left rotation
        // 1 2 3 4 5 6. 2 1 6 5 4 3
        // 1 2 3 4 5 6. 4 3 2 1 5 6
        reverse(nums, 0, partIndex);
        reverse(nums, partIndex + 1, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        rotate(arr, k);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}

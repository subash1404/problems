package Migration;
import java.util.Scanner;

public class MaxProdSubArray {

    // 1. The array is all +ve
    // 2. The array is contains even no of -ve's
    // In both the above cases ans is the product of the whole array
    // 3. The array contains odd no of negatives, we need to eliminate on of the negatives to get the maximum subarray
    // Eg: [ 2, -1, 6, -4, 5, -3] -> Here eliminating -1 will give me the maximum subarray
    // so the answer is going to be a prefix or suffix subarray to a negative number, so we calculate both the prefix and suffix subarrays
    static public int maxProduct(int[] nums) {
        double ans = nums[0];
        double prefixProduct = 1, suffixProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            // If we encounter a zero we reset the prefix or suffix product to 1, because carrying a zero will make the product zero
            // [ (1, 2, 3) 0 (4, 5, 6) 0 (7, 8, 9) ] its like we are starting to calculate the product of a new array
            if (prefixProduct == 0)
                prefixProduct = 1;
            if (suffixProduct == 0)
                suffixProduct = 1;
            prefixProduct *= nums[i];
            suffixProduct *= nums[nums.length - 1 - i];
            ans = Math.max(ans, Math.max(prefixProduct, suffixProduct));
            // System.out.println(temp+" : "+ans);
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
    }
}

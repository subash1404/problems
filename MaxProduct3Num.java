
// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
// Example 1:

// Input: nums = [1,2,3]
// Output: 6
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 24
// Example 3:

// Input: nums = [-1,-2,-3]
// Output: -6
 
import java.util.Scanner;

public class MaxProduct3Num {
    static public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int ele : nums) {
            if (max1 <= ele) {
                max3 = max2;
                max2 = max1;
                max1 = ele;
            }
            if (ele >= max2 && ele < max1) {
                max3 = max2;
                max2 = ele;
            }
            if (ele >= max3 && ele < max2) {
                max3 = ele;
            }
            if (ele <= min1) {
                min2 = min1;
                min1 = ele;
            }
            if (ele <= min2 & ele > min1) {
                min2 = ele;
            }
        }
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }
        int result = maximumProduct(array1);
        System.out.println(result);
    }
}

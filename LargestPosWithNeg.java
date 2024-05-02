// Given an integer array nums that does not contain any zeros, find the largest positive integer k such that -k also exists in the array.

// Return the positive integer k. If there is no such integer, return -1.

 

// Example 1:

// Input: nums = [-1,2,-3,3]
// Output: 3
// Explanation: 3 is the only valid k we can find in the array.
// Example 2:

// Input: nums = [-1,10,6,7,-7,1]
// Output: 7
// Explanation: Both 1 and 7 have their corresponding negative values in the array. 7 has a larger value.
import java.util.*;
public class LargestPosWithNeg {

    static public int findMaxK(int[] nums) {
        int left = 0, right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == 0 && Math.abs(nums[left]) > max) {
                max = Math.abs(nums[left]);
                return max;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }
        int result = findMaxK(array1);
        System.out.println(result);

    }
}

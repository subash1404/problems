// Given an array of integers nums sorted in non-decreasing order,find the starting and ending position of a 
//given target value.

// If target is not found in the array,return[-1,-1].

// You must write an algorithm with O(log n)runtime complexity.

// Example 1:

// Input:nums=[5,7,7,8,8,10],target=8 Output:[3,4]
import java.util.Arrays;
import java.util.Scanner;

public class FirstAndLastOcc {
    static public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid;
                last = mid;
                while (first > 0 && nums[first - 1] == target)
                    first--;
                while (last < nums.length - 1 && nums[last + 1] == target)
                    last++;
                break;
            } else if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return new int[] { first, last };
    }
    static public int[] searchRange1(int[] nums, int target) {
        int start = -1, end = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }
        return new int[] { start, end };
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arr1 = searchRange(arr,target);
        int[] arr2 = searchRange1(arr,target);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }

}
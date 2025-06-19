package Migration;
import java.util.Scanner;

class MaximumSubArray {
    static public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (currentSum > maxSum) {
                endIndex = i;
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
                startIndex = i + 1;
            }
        }
        System.out.println(startIndex + " " + endIndex);
        return maxSum;
    }

    // This will not fail if all the numbers are negative
    static public int maxSubArray1(int[] nums) {
        int currentSum = nums[0];
        int startIndex = 0;
        int endIndex = 0;
        int tempStart = 0;
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currentSum + nums[i]) {
                tempStart =i;
                currentSum = nums[i];
            } else {
                currentSum += nums[i];
            }
            if (currentSum > maxSum) {
                startIndex = tempStart;
                endIndex = i;
                maxSum = currentSum;
            }
        }
        System.out.println(startIndex + " " + endIndex);
        return maxSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(arr));
    }
}
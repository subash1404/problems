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
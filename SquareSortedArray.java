import java.util.Scanner;

public class SquareSortedArray {
        static public int[] sortedSquares(int[] nums) {
            int left = 0, right = nums.length - 1, arrIndex = nums.length - 1;
            int[] result = new int[nums.length];
            boolean hasNegative = true, hasPositive = true;
            while (arrIndex >= 0) {
                    int rightAns = (int) Math.pow(nums[right], 2);
                    int leftAns = (int) Math.pow(nums[left], 2);
                    if (leftAns <= rightAns) {
                        result[arrIndex] = rightAns;
                        right --;
                        arrIndex--;
                    }
                    else if (leftAns >= rightAns) {
                        result[arrIndex] = leftAns;
                        left++;
                        arrIndex--;
                    }
                }
                return result;
            }
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] result = sortedSquares(arr);
        for(int i : result){
            System.out.print(i+" ");
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    static int[] sort(int[] nums,int max){
        // max - maximum element in the array
        int[] arr = new int[max+1]; // create a array of length of the maximum number
        int[] ans = new int[nums.length]; // ascending order
        int[] rans = new int[nums.length]; // descending order

        // calculate the occourence of each number in the nums
        for(int i : nums){
            arr[i]++; 
        }

        // Assign the consecutive sum of previous indices
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            arr[i] = sum;
        }


        // eg: given nums array 3 2 0 1 2
        // the arr array would be 1 1 2 1
        // the sum array would be 1 2 4 5
        // iterating the nums array
        // iteration:0(nums[0] = 3) index = 4, ans = 0 0 0 0 3
        // iteration:1(nums[0] = 2) index = 3, ans = 0 0 0 2 3 
        // iteration:1(nums[0] = 0) index = 0, ans = 0 0 0 2 3 
        // iteration:1(nums[0] = 1) index = 1, ans = 0 1 0 2 3 
        // iteration:1(nums[0] = 2) index = 1, ans = 0 1 2 2 3 
        for(int i : nums){
            int index = --arr[i];
            ans[index] = i;
            rans[nums.length - 1 - index] = i;
        }
        for(int i : rans){
            System.out.print(i+" ");
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] array1 = new int[n];
        for (int i = 0; i < n; i++) {
            array1[i] = sc.nextInt();
        }
        int[] result = sort(array1,8);
        Arrays.stream(result).forEach(a -> System.out.print(a+" "));
        Arrays.stream(result).forEach(a -> System.out.print(a + " "));

    }
}

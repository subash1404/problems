//Two sum but the array is sorted

import java.util.Scanner;

public class TwoSum2 {
    static public int[] twoSum(int[] numbers, int target) {
        int left = 0,right = numbers.length-1;
        while (left < right) {
            int sum = numbers[left]+numbers[right];
            if(sum == target){
                return new int[]{left,right};
            }
            if( sum < target){
                left++;
            }else{
                right--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = twoSum(arr,target);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        // Arrays.stream(result).forEach(System.out::print);
    }
}

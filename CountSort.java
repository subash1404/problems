import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    static int[] sort(int[] nums,int max){
        int[] arr = new int[max+1];
        int[] ans = new int[nums.length];
        for(int i : nums){
            arr[i]++; 
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            arr[i] = sum;
        }
        for(int i : nums){
            int index = --arr[i];
            ans[index] = i;
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

    }
}

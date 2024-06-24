import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KthMissingNumber {
    static public int findKthPositive(int[] arr, int k) {
        List<Integer> nums = new ArrayList<>();
        int count =0;
        for(int i : arr){
            nums.add(i);
        }
        for(int i=1;i<=arr[arr.length-1]+k;i++){
            if(!nums.contains(i)) count++;
            if(count == k) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int x = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(findKthPositive(arr,x));
}
}

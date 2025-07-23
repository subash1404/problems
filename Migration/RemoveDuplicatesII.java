package Migration;
import java.util.Scanner;

public class RemoveDuplicatesII {
    static public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (j == 1 || nums[i] != nums[j - 2])
                nums[j++] = nums[i];
        }
        return j;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Count :"+ removeDuplicates(arr));        
        for(int i:arr){
            System.out.print(i+" ");
        }
        sc.close();
    }
}

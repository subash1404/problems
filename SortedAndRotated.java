import java.util.Scanner;

public class SortedAndRotated {
    static public boolean check(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        if (nums[0] < nums[nums.length - 1])
            count++;
        return count < 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(check(arr));
    }
}

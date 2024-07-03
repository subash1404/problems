import java.util.Scanner;

public class MaxProdSubArray {
    static public int maxProduct(int[] nums) {
        double ans = nums[0];
        double pr = 1, su = 1;
        for (int i = 0; i < nums.length; i++) {
            if (pr == 0)
                pr = 1;
            if (su == 0)
                su = 1;
            pr *= nums[i];
            su *= nums[nums.length - 1 - i];
            ans = Math.max(ans, Math.max(pr, su));
            // System.out.println(temp+" : "+ans);
        }
        return (int) ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProduct(arr));
    }
}

package Migration;
import java.util.*;
public class RearrangeElemBySign {
    static public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int posIndex = 0, negIndex = 0;
        for (int i : nums) {
            if (i >= 0)
                pos[posIndex++] = i;
            else
                neg[negIndex++] = i;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            nums[2 * i] = pos[i];
            nums[2 * i + 1] = neg[i];
        }
        return nums;
    }
    static public int[] rearrangeArray2(int[] nums) {
        int[] ans = new int[nums.length];
        int posIndex = 0, negIndex = 1;
        for (int i : nums) {
            if (i >= 0) {
                ans[posIndex] = i;
                posIndex = posIndex + 2;
            } else {
                ans[negIndex] = i;
                negIndex = negIndex + 2;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = rearrangeArray(arr);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(rearrangeArray2(arr)));
    }
}

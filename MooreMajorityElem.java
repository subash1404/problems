import java.util.Scanner;

public class MooreMajorityElem {
    static public int majorityElement(int[] nums) {
        int votes = 0, candidate = -1;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                candidate = nums[i];
                votes = 1;
            } else {
                if (nums[i] == candidate)
                    votes++;
                else
                    votes--;
            }
        }
        return candidate;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(majorityElement(arr));
}
}

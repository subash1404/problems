package Migration;
import java.util.Scanner;

/*
 * Moore's Algorithm
 * "If the current number isn’t helping my current candidate win, I’ll cancel it out."
    So, every non-candidate is like a vote against the current candidate. 
    If there's a true majority element, its frequency is high enough to stay as the candidate even after these cancellations.
 */

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

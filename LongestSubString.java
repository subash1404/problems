// Find the length of the longest substring without repitition
import java.util.*;

public class LongestSubString {
    static public int lengthOfLongestSubstring(String s) {
        int left = 0, max = 0;
        int[] arr = new int[128];
        Arrays.fill(arr, -1);
        for (int right = 0; right < s.length(); right++) {
            if (arr[s.charAt(right)] >= left) {
                left = arr[s.charAt(right)] + 1;
            }
            arr[s.charAt(right)] = right;
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(sc.nextLine()));
    }
}

package Migration;
// Find the length of the longest substring without repitition
import java.util.*;

public class LongestSubString {

    // Brute for solution
    // Generate all the possible substrings and look for a substring with no repeating characters and store the length of the substring
    // Use arr[256] to remember the characters seen previously
    // If the character was seen previously break the j loop

    static public int lengthOfLongestSubstring(String s) {
        int left = 0, max = 0;
        int[] arr = new int[128];
        // Fill the array with -1
        Arrays.fill(arr, -1);
        for (int right = 0; right < s.length(); right++) {
            if (arr[s.charAt(right)] >= left) {
                // If the last seen index of the character in the array is > left 
                // means that the current substring includes a repeating character
                // So assign left to the next index of the last seen index
                left = arr[s.charAt(right)] + 1;
            }
            // update the last seen index of the character in the array
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

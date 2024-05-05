// Given a string s and a dictionary of n words dictionary, find out if "s" can be segmented into a space-separated
// sequence of dictionary words.
// Return 1 if it is possible to break the s into a sequence of dictionary words, else return 0. 

// Note: From the dictionary dictionary each word can be taken any number of times and in any order.

// Example 1:

// Input:
// n = 6
// s = "ilike"
// dictionary = { "i", "like", "sam", "sung", "samsung", "mobile"}
// Output:
// 1
// Explanation:
// The string can be segmented as "i like".
import java.util.*;
public class WordBreak {

    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // Step 1: Create a set for quick lookup of dictionary words
        Set<String> set = new HashSet<>(dictionary);

        // Step 2: Create a DP array of length n + 1
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // Empty string can always be segmented

        // Step 3: Fill the DP array
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // Check if substring s[j:i] is in the dictionary and dp[j] is true
                if (set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further once we've found a valid partition
                }
            }
        }

        // Step 4: The result is whether the full string can be segmented
        return dp[n] ? 1 : 0;
    }

    public static void main(String[] args) {
        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("lrbbmqb");
        dictionary.add("owkk");
        dictionary.add("cd");
        dictionary.add("r");

        String s = "lrbbmqbabowkkab";
        int n = s.length();

        int result = wordBreak(n, s, dictionary); // Expected output: 1
        System.out.println("Can the string be segmented? " + result);
    }
}

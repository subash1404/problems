// Given two strings A and B, find if A is a subsequence of B.

// Example 1:

// Input:
// A = AXY 
// B = YADXCP
// Output: 0 
// Explanation: A is not a subsequence of B
// as 'Y' appears before 'A'.

class SubString {
    boolean isSubSequence(String A, String B) {
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < A.length() && bIndex < B.length()) {
            if (A.charAt(aIndex) == B.charAt(bIndex)) {
                aIndex++;
            }
            bIndex++;
        }
        return aIndex == A.length();
    }
}
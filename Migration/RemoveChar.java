package Migration;
// Given two strings string1 and string2, remove those characters from first string(string1) 
//which are present in second string(string2). Both the strings are different and contain 
//only lowercase characters.
// NOTE: Size of  first string is always greater than the size of  second string( |string1| > |string2|).
 

// Example 1:

// Input:
// string1 = "computer"
// string2 = "cat"
// Output: "ompuer"
// Explanation: After removing characters(c, a, t)
// from string1 we get "ompuer".
import java.util.*;
public class RemoveChar {
    static String removeChars(String string1, String string2) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder res = new StringBuilder();
        for (char ch : string2.toCharArray()) {
            set.add(ch);
        }
        for (char ch : string1.toCharArray()) {
            if (!set.contains(ch)) {
                res.append(ch);
            }
        }
        return res.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(removeChars(str1,str2));
    }
}
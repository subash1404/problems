// Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and 
//ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, 
//do nothing.

// For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at 3 (inclusive). The resulting string will be "dcbaefd".
// Return the resulting string.

 

// Example 1:

// Input: word = "abcdefd", ch = "d"
// Output: "dcbaefd"
// Explanation: The first occurrence of "d" is at index 3. 
// Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".

import java.util.Scanner;

public class ReversePrefix {
        // static public String reversePrefix(String word, char ch) {
        //     int index = word.indexOf(ch);
        //     if(index == -1){
        //         return word;
        //     }
        //     StringBuilder sb = new StringBuilder(word.substring(0, index+1));
        //     String rem = word.substring(index+1);
        //     return sb.reverse().toString()+rem;
        // }
        static public String reversePrefix(String word, char ch) {
            int index = word.indexOf(ch);
            if (index == -1) {
                return word;
            }
            StringBuilder sb = new StringBuilder(word);
            for (int i = index; i >= 0; i--) {
                sb.setCharAt(index - i, word.charAt(i));
            }
            return sb.toString();
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            char ch = sc.nextLine().charAt(0);
            System.out.println(reversePrefix(str, ch)); 
        }
}

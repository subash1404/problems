package Migration;
// Given a string s, reverse only all the vowels in the string and return it.

// The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
import java.util.*;
public class ReverseVowels {
    static public boolean isVowel(char ch) {

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {
            return true;
        } else
            return false;
    }

    static public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int p1 = 0, p2 = sb.length() - 1;
        while (p1 < p2) {
            boolean cond1 = isVowel(sb.charAt(p1));
            boolean cond2 = isVowel(sb.charAt(p2));
            if (cond1 && cond2) {
                char temp = sb.charAt(p1);
                sb.setCharAt(p1, sb.charAt(p2));
                sb.setCharAt(p2, temp);
                p1++;
                p2--;
            } else if (cond1 && !cond2) {
                p2--;
            } else if (!cond1 && cond2) {
                p1++;
            } else {
                p1++;
                p2--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseVowels(s));
    }
}

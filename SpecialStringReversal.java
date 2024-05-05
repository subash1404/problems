//Reverse the given string keeping the position of special characters intact
import java.util.*;
public class SpecialStringReversal {
    static public String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (Character.isAlphabetic(sb.charAt(left)) && Character.isAlphabetic(sb.charAt(right))) {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            } else if (!Character.isAlphabetic(sb.charAt(left))) {
                left++;
            } else if (!Character.isAlphabetic(sb.charAt(right))) {
                right--;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(reverse(str));
    }
}

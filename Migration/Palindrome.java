package Migration;
import java.util.Scanner;

class Palindrome {
    static public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right))) {
                    left++;
                    right--;
                } else {
                    System.out.println("Cut at" + s.charAt(left) + " " + left);
                    System.out.println(Character.isLetterOrDigit(','));
                    System.out.println(String.valueOf(s.charAt(left)).toLowerCase());
                    System.out.println(String.valueOf(s.charAt(right)).toLowerCase());
                    return false;
                }
            }
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userInp = sc.nextLine();
        System.out.println(isPalindrome(userInp));
    }
}
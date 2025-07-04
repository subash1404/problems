//Find the first non duplicate element in a string

import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = 0;
        char firstNonRepeatingCharacter = ' ';
        for (char s : str.toCharArray()) {
            if (str.indexOf(s) == str.lastIndexOf(s)) {
                firstNonRepeatingCharacter = s;
                break;
            } else {
                index += 1;
            }
        }
        if (index == str.length()) {
            System.out.print("All Characters are repeating\n");
        } else {
            System.out.println(firstNonRepeatingCharacter);
        }
    }
}

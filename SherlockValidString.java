/*Sherlock considers a string to be valid if all the characters occur at same no. of times. It is also considered valid if he remove just one 
characterat on eindex and the remaining characters will occur the same no of times return yes if the string is valid else no */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SherlockValidString {

    public static void main(String[] args) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String s = sc.nextLine().toLowerCase();
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            hmap.put(cArray[i], hmap.getOrDefault(cArray[i], 0) + 1);
        }
        int[] arr = new int[hmap.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> e : hmap.entrySet()) {
            arr[i++] = e.getValue();
        }

        Arrays.sort(arr);
        if (arr.length == 1) {
            System.out.print("YES");
        }
        int first = arr[0];
        int second = arr[1];
        int last = arr[arr.length - 1];
        int secondLast = arr[arr.length - 2];
        if (first == last) {
            System.out.println("YES");
            System.out.println(s);
        } else if (second == last && first == 1) {
            System.out.println("YES");
            System.out.println(s.substring(1, s.length()));
        } else if (secondLast == last - 1 && first == secondLast) {
            System.out.println("YES");
            System.out.print(s.substring(0, s.length() - last));
            System.out.println(s.substring(s.length() - last + 1));

        } else {
            System.out.println("No");
        }
    }

}
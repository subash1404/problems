package Migration;
import java.util.HashMap;
import java.util.Scanner;

public class Isomorphic {

    // Approach using arrays for tracking character counts
    static public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr1 = new int[200];
        int[] arr2 = new int[200];
        for (int i = 0; i < s.length(); i++) {
            if (arr1[s.charAt(i)] != arr2[t.charAt(i)])
                return false;

            arr1[s.charAt(i)] = i + 1;
            arr2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    // Approach using 2 HashMaps
    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Integer> charIndexS = new HashMap<>();
        HashMap<Character, Integer> charIndexT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!charIndexS.containsKey(s.charAt(i))) {
                charIndexS.put(s.charAt(i), i);
            }

            if (!charIndexT.containsKey(t.charAt(i))) {
                charIndexT.put(t.charAt(i), i);
            }

            if (!charIndexS.get(s.charAt(i)).equals(charIndexT.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;        
    }

    // Approach using 1 HashMap
    public boolean isIsomorphic3(String s, String t) {
        HashMap<Character, Character> charMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            if (charMap.containsKey(sc)) {
                if (charMap.get(sc) != tc) {
                    return false;
                }
            } else if (charMap.containsValue(tc)) {
                return false;
            }

            charMap.put(sc, tc);
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isIsomorphic(s, t));
    }
}

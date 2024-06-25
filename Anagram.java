import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

public class Anagram {
    static public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        // anagram naaagram
        // a:3 n:1 g:1 r:1 m:1 
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)-1);
            }else{
                return false;
            }
            if(map.get(ch) == -1) return false;
        }
        return true;
    }
    static public boolean isAnagram2(String s, String t) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            arr[ch - 'a']--;
        }
        for (int val : arr) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
    static public boolean isAnagram3(String s, String t) {
        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr,tArr);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(isAnagram(str1, str2));
        System.out.println(isAnagram2(str1, str2));
        System.out.println(isAnagram3(str1, str2));
        sc.close();
    }
}
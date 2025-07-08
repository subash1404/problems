package Migration;
import java.util.*;

public class Pangram {
    static boolean check(String str){
        HashSet<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        for(char ch : set) System.out.print(ch+" ");
        System.out.println(set.size());
        return set.size() == 26;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toLowerCase().trim().replace(" ", "");
        System.out.println(str);
        if(check(str))  System.out.println("true"); else System.out.println("false");
    }
}

//Find all the duplicate elements in the given string
import java.util.*;

public class FindDuplicateString {
    static List<Character> findDuplicates(String str) {
        Set<Character> visitedSet = new HashSet<>();
        List<Character> dupList = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            if (visitedSet.contains(ch)) {
                if (!dupList.contains(ch)) {
                    dupList.add(ch);
                }
            } else {
                visitedSet.add(ch);
            }
        }
        return dupList;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        List<Character> duplicates = findDuplicates(str);

        for (char d : duplicates) {
            System.out.print(d + " ");
        }
    }
}

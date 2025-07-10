package Migration;
import java.util.*;

public class PascalTriangle {
    static int printElem(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) { // Forumal for finding an elem in nth row , cth column is nCr = n! / (r! *
                                      // (n-r)!)
            res = res * (n - i);
            res /= i + 1;
        }
        return res;
    }

    static List<Integer> generateRow(int r) {
        List<Integer> list = new ArrayList<>();
        list.add(1); // first elem of all rows is 1
        int res = 1;
        for (int i = 1; i < r; i++) { // start from 1
            res = (res * (r - i)) / i; // simple pattern
            list.add(res);
        }
        return list;
    }

    // Brute force solution is to calculate all the values using the formula and the
    // print it
    static List<List<Integer>> printTriangle(int n) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            List<Integer> tempList = generateRow(i);
            list.add(tempList);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(printElem(r - 1, c - 1));
        System.out.println(generateRow(r - 1));
        System.out.println(printTriangle(r));

    }
}

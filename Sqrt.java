import java.util.Scanner;

public class Sqrt {
    //Newton method
    static public double newtonMethod(int x) {
        if(x == 0) return 0;
        double tol = 0.1;
        double guess = x /2;
        while( guess * guess - x> tol ){
            guess = (guess + x/guess) / 2;
        }
        return guess;
    }
    //Binary Search
    //Note that binary search only returns nearest int value
    static public int binarySearch(int x) {
        if (x == 0)
            return 0;
        int first = 1, last = x;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (mid == x / mid)
                return mid;
            else if (mid > x / mid)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return last;
    }

    //Perfect Squares
    static public boolean perfSquares(int x) {
        if (x == 0)
            return true;
        int first = 1, last = x;
        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (x == mid * mid) //this condtion is changed like this, otherwise it will return true for inputs like 5
                // return mid;
                return true;
            else if (mid > x / mid)
                last = mid - 1;
            else
                first = mid + 1;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(binarySearch(n));
        System.out.println(perfSquares(5));
        sc.close();
    }
}

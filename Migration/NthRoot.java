package Migration;
import java.util.Scanner;

public class NthRoot {
    public static int findNthRoot(int n, int m) {
        if (m == 1)
            return 1;
        // If a valid integer x exists such that x^n == m, it will fall within [1, m/n]
        // If we directly assign m it can overflow for large numbers
        int low = 1, high = m / n;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (Math.pow(mid, n) == m) {
                return mid;
            } else if (Math.pow(mid, n) < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    // return m^n (Binary Exponentiation) TC -> log(n)
    // Math.pow(log2(n)) which is the same it uses binary exponentiation under the hood
    public static int findPowerN(int m, int n) {
        int ans = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= m;
                n = n - 1;
            } else {
                m = m * m;
                n = n / 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(findNthRoot(n, m));
        System.out.println(findPowerN(5, 3));
        System.out.println(findPowerN(10, 3));
        System.out.println(findPowerN(1, 1));
        System.out.println(findPowerN(25, 4));
        sc.close();
    }
}

import java.util.*;
public class SumofSquareNums {

    static public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long prod = left * left + right * right;
            if (prod == c) {
                return true;
            } else if (prod < c)
                left++;
            else
                right--;
        }
        return false;
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(judgeSquareSum(n));
    }
}

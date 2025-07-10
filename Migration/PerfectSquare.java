package Migration;
//Newton method
import java.util.Scanner;

public class PerfectSquare {
    static boolean isPerfectSquare(int n){
        if(n == 0 || n == 1){
            return true;
        }
        if( n < 0){
            return false;
        }
           int left = 0,right = n;
        while(left <= right){
            int mid = left + (right - left)/2;
            int square = mid*mid;
            if(square == n){
                return true;
            }else if(square > n){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }

    static boolean isPerfectSquareNewton(int n) {
        if (n < 2)
            return true;

        long x = n / 2;
        while (x * x > n) {
            x = (x + n / x) / 2;
        }
        return x * x == n;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(isPerfectSquare(n))
        System.out.println("Perfect Square");
        else
        System.out.println("Not a Perfect Square");
    }
}

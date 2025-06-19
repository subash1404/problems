package Migration;
import java.util.*;

public class ToptoBottomTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num += n - j;
            }
            System.out.println();
        }
    }
}
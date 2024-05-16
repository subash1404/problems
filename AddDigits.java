import java.util.Scanner;

public class AddDigits {
    static int sum(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }
        return sum;
    }

    static public int addDigits(int num) {
        while (num > 9) {
            num = sum(num);
        }
        return num;
        // optimal method
        // if (num == 0) {
        //     return 0;
        // }
        // return num % 9 == 0 ? 9 : num % 9;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(addDigits(num));
    }
}

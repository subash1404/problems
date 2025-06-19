import java.util.Scanner;

public class AddDigittoAll {
    static int convert(int n){
        StringBuilder num = new StringBuilder(Integer.toString(n));
        StringBuilder result = new StringBuilder();
        for(int i=0;i<num.length();i++){
            int a =  (num.charAt(i)+10) - '0';
            result.append(a);
        }
        return Integer.parseInt(result.toString());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(convert(n));
    }
}

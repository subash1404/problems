import java.util.Scanner;

public class Atoi {
    static public int myAtoi(String s) {
        s= s.trim();
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int num = 0;
        int i=0;
        if(s.length() == 0) return 0;
        boolean isNegative = false;
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            if(s.charAt(i) == '-') isNegative = true;
            i++;
        }
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(num > max / 10 || (num == max / 10 && s.charAt(i) - '0' > max % 10))
                return isNegative ? min : max;
            num = num * 10 + s.charAt(i) - '0';
            i++;
        }
        return isNegative ? num*-1 : num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(myAtoi(str));
    }
}

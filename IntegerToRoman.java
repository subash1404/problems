import java.util.Scanner;

public class IntegerToRoman {
    static String intToRoman(int n){
    String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String[] hrds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String[] thds = {"","M","MM","MMM"};

    return thds[n/1000]+hrds[(n%1000)/100]+tens[(n%100)/10]+ones[n%10];
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println(intToRoman(inp));
    }
}

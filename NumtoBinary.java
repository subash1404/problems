import java.util.Scanner;

public class NumtoBinary {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num =  sc.nextInt();
    // long number = 0;
    // while(num > 0 ){
    //     long rem  = num  % 2;
    //     System.out.print(rem);
    //     num = num / 2; 
    // }
    // op of the above while loop is reverse
    tobin(num);
    }

    public static void tobin(int n){
        if(n == 0) return ;
        tobin(n/2);
        System.out.print(n % 2);
    }
}

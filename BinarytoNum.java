import java.util.Scanner;

public class BinarytoNum {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Long num =  sc.nextLong();
    long number = 0;
    int n = 0;
    while(num > 0){
        long rem = num % 10;
        number += (long)(rem * Math.pow(2,n));
        num = num / 10;
        n++;
    }
    System.out.println(number);
    }
    
}
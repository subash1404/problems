import java.util.Scanner;

public class Pal {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        //Traditional method
        int n = sc.nextInt();
        int temp = n,sum=0;
        while(n > 0 ){
            int rem = n%10;
            sum = (sum*10)+rem;
            n=n/10;
        }
        if(temp == sum){
            System.out.println("Palindrome");
        }else{
        System.out.println("Not Palindrome");
        }


        //Palindrome for integer using StrinBuilder 
        // int num = sc.nextInt();
        // String n = Integer.toString(num);
        // // String n1 = String.valueOf(num);
        // StringBuilder revNum = new StringBuilder(n);
        // revNum = revNum.reverse();
        // if(revNum.toString().equals(n)){
        // System.out.println("Palindrome");
        // }else{
        // System.out.println("NotPalindrome");
        // }

        //Palindrome using stringBuiler and reverse()
        // String inp = sc.nextLine().toLowerCase();
        // StringBuilder rev = new StringBuilder(inp);
        // rev = rev.reverse();
        // if(rev.toString().equals(inp)){
        //     System.out.println("Palindrome");
        // }else{
        //     System.out.println("NotPalindrome");
        // }


        // String rev="";
        // for(char ch : inp.toCharArray()){
        //     rev+=Character.toString(ch);
        // }
        // if(rev.equals(inp)){
        //                 System.out.println("Palindrome"); 
        // }else{
        //     System.out.println("Not Palindrome");

        // }
    }
}

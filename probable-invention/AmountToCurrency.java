import java.util.Scanner;

public class AmountToCurrency {
    public static void countCurrency(int amount) {
        int[] notes = new int[] { 2000, 500, 200, 100, 50, 20, 10, 5, 1 };
        int[] noteCounter = new int[9];

        for (int i = 0; i < 9; i++) {
            if (amount >= notes[i]) {
                noteCounter[i] = amount / notes[i];
                amount = amount % notes[i];
            }
        }

        // Print notes
        System.out.println("Currency Count ->");
        for (int i = 0; i < 9; i++) {
            if (noteCounter[i] != 0) {
                System.out.println(notes[i] + " : "
                        + noteCounter[i]);
            }
        }
    }
    public static void main(String[] args){
        
    
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        countCurrency(amount);
        // int twoThsd = amount/2000;
        // int fiveHrd = (amount%2000) / 500;
        // int hrds = (amount%500) / 100;
        // int fiftys = (amount%100) / 50;
        // int tewntys = (amount%50) / 20;
        // int tens = ((amount%50)%20) / 10;
        // int fives = (amount%10) / 5;
        // int ones = (amount % 5);
        // System.out.println(twoThsd +" * "+"2000");
        // System.out.println(fiveHrd +" * "+"500");
        // System.out.println(hrds +" * "+"100");
        // System.out.println(fiftys +" * "+"50");
        // System.out.println(tewntys +" * "+"20");
        // System.out.println(tens +" * "+"10");
        // System.out.println(fives +" * "+"5");
        // System.out.println(ones +" * "+"1");
    }
}

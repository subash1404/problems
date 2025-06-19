package Migration;
import java.util.HashMap;
import java.util.Scanner;

// Example 1:

// Input: num = 3749

// Output: "MMMDCCXLIX"

// Explanation:

// 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
//  700 = DCC as 500 (D) + 100 (C) + 100 (C)
//   40 = XL as 10 (X) less of 50 (L)
//    9 = IX as 1 (I) less of 10 (X)
// Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
// Forms like IL (50 - 1) or IC (100 - 1) are not valid in Roman numerals.
// The Romans only used the subtractive notation with one "step" down:
// You can subtract I only from V and X.
// You can subtract X only from L and C.
// You can subtract C only from D and M.

public class IntegerToRoman {

    static String intToRoman(int n){
    String[] ones = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
    String[] tens = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
    String[] hrds = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
    String[] thds = {"","M","MM","MMM"};
    
    return thds[n/1000]+hrds[(n%1000)/100]+tens[(n%100)/10]+ones[n%10];
    }

    public static String intToRoman2(int num) {
        
        //if you are allowed to use only crucial symbols. Then use this solution

        HashMap<Integer,String> symbols = new HashMap<Integer,String>();
        String result = "";
        int pos = 0;
        symbols.put(1,"I");symbols.put(5,"V");symbols.put(10, "X"); symbols.put(50,"L");
        symbols.put(100,"C"); symbols.put(500,"D");symbols.put(1000,"M");

        while(num > 0){
            int temp = num % 10;   //get the digit
            String t = new String();
            //System.out.println(temp);
            int key = (int) Math.pow(10, pos);   //get place of number like if 1s/1os/100th place...

            if(temp < 4){
                String base = symbols.get(key);
                // String repitition logic instead of .repeat()
                // First a char array of size temp ['\0','\0'] is created and is converted to string (\0\0)
                // Then it is replaced with the base character
                t = new String(new char[temp]).replace("\0", base);  
            }else if(temp == 4){
                t =  symbols.get(key) + symbols.get( 5 * key);   
            }else if (temp < 9) {
                t = symbols.get( 5 * key) + symbols.get(key).repeat(temp - 5);
            }else{
                t =  symbols.get(key) + symbols.get( (int) Math.pow(10, pos+1)); 
            }

            result = t + " " + result;
            num /= 10;
            pos++;
        }
        return result; 
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        System.out.println(intToRoman(inp));
        sc.close();
    }
}

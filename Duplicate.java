//Find the first non duplicate element in a string

import java.util.Scanner;

public class Duplicate {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int index = 1;
        char fnc = ' ';
        for(char s : str.toCharArray()){
            if(str.indexOf(s) == str.lastIndexOf(s)){
                fnc = s;
                break;
            }else{
                index+=1;
            }
        }
        if(index == str.length()-1){
            System.out.print("All Characters are repeating\n");
        }else{
            System.out.println(fnc);
        }
    }
}


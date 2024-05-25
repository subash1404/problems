import java.util.*;

public class ValidParanthesis {
    static public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        s=s.replaceAll("[A-Za-z\\+\\-\\*\\/%]","");
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || stack.pop()!=c) return false;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(isValid(s)) { System.out.println("Valid");}
        else { System.out.println("Not valid");}
    }
    
}

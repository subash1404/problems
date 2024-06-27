import java.util.Scanner;
import java.util.Stack;

public class RemoveOuterParan {
    static public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (count > 0) // If the count is > 0 wkt the paranthesis is being enclosed, we add it to the res
                    res.append(ch);
                count++;
            } else if (ch == ')') {
                if (count > 1) // If the count is > 1 we know that this closing paran is not the closing paran
                                // of the enclosing paranthesis
                    res.append(ch);
                    count--;
            }
        }
        return res.toString();
    }

    // Using stack 
    // similar to the above function
    static public String removeOuterParentheses2(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                if(stack.size() > 0) res.append(ch);
                stack.push(ch);
            }
            else if(ch == ')') {
                stack.pop();
                if(stack.size() > 0) res.append(ch);
            }
        }
        return res.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(removeOuterParentheses(str));
    }
}

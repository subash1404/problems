package Migration;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ReverseStringBetweenParan {
    // TC : O(n^2) loop->n,reverse->n
    static public String reverseParentheses(String s) {
        Deque<Integer> indStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char char_s : s.toCharArray()) {
            if (char_s == '(') {
                indStack.push(res.length());
            } else if (char_s == ')') {
                int startInd = indStack.pop();
                String reversed = new StringBuilder(res.substring(startInd)).reverse().toString();
                res.replace(startInd, res.length(), reversed);
            } else {
                res.append(char_s);
            }
        }
        return res.toString();
    }

    static public String reverseParentheses2(String s) {
        Stack<Integer> st = new Stack<>();
        int[] pair = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') st.push(i);
            else if(s.charAt(i) == ')'){
                int ind = st.pop();
                pair[i] = ind;
                pair[ind] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0,d=1;i<s.length();i+=d){
            if(s.charAt(i) == '(' || s.charAt(i) == ')'){
                i = pair[i];
                d *= -1;
            }else sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(reverseParentheses2("(abcd)"));
    }
}
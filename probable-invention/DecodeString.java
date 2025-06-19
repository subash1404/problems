import java.util.*;

public class DecodeString {
    static String decodedString(String s) {
        Stack<String> st = new Stack<>();
        char c[] = s.toCharArray();
        int n = c.length;
        for (int i = 0; i < n;) {
            // Push into the stack if there is a opening square bracket
            if (c[i] == '[') {
                st.push("[");
                i++;
            } else if (c[i] == ']') {
                String str = "";
                // If there is a closing square bracket, pop the content till the opening
                // bracket
                while (st.peek().charAt(0) != '[') {
                    str = st.pop() + str;
                }
                // Pop the opening square bracket
                st.pop();
                // Pop the multiplier
                int times = Integer.parseInt(st.pop());
                String temp = str;
                while (times-- > 1) {
                    str += temp;
                }
                st.push(str);
                i++;
            }
            // When encountered numeric characters store them in a string and push it in the
            // stack
            else if (c[i] >= '0' && c[i] <= '9') {
                String str = "";
                while (i < n && c[i] >= '0' && c[i] <= '9') {
                    str += c[i];
                    i++;
                }
                st.push(str);
            }
            // When encountered alphabetic characters store them in a string and push it in
            // the stack
            else {
                String str = "";
                while (i < n && c[i] >= 'a' && c[i] <= 'z') {
                    str += c[i];
                    i++;
                }
                st.push(str);
            }
        }
        String res = "";
        while (!st.isEmpty()) {
            res = st.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(decodedString(str));
    }
}
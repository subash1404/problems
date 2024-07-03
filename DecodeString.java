import java.util.*;
public class DecodeString{
    static String decodedString(String s){
        Stack<String> st = new Stack<>();
        char c[] = s.toCharArray();
        int n = c.length;
        for(int i=0;i< n;){
            if(c[i] == '['){
                st.push("[");
                i++;
            }else if(c[i] == ']'){
                String str = "";
                while(st.peek().charAt(0)!= '['){
                    str = st.pop()+str;
                }
                st.pop();
                int times = Integer.parseInt(st.pop());
                String temp = str;
                while(times-- > 1){
                    str += temp;
                }
                st.push(str);
                i++;
            }else if(c[i] >= '0' && c[i] <= '9'){
                String str = "";
                while(i < n && c[i] >= '0' && c[i] <= '9' ){
                    str += c[i];
                    i++;
                }
                st.push(str);
            }else{
                 String str = "";
                 while(i < n && c[i] >= 'a' && c[i] <= 'z' ){
                    str += c[i];
                    i++;
                }
                st.push(str);
            }
        }
        String res= "";
        while(!st.isEmpty()){
            res = st.pop()+res;
        }
        return res;
    }
    public static void main(String[] args ) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(decodedString(str));
    }
}
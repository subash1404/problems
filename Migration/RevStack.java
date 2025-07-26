package Migration;
import java.util.*;
public class RevStack {
public static void main(String[] args) {
    
    Stack<Character> stack = new Stack<>();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    stack.push('"');
    for(char ch : str.toCharArray()){
        stack.push(ch);
        }
    stack.push('"');
    while(!stack.isEmpty()){
        System.out.print(stack.pop());
    }
    
    // HashSet<Character> set = new HashSet();
    // set.add('a');
    // set.add('b');
    // set.add('c');
    // set.add('c');
    // set.add('d');
    // set.add('d');
    // Iterator it = set.iterator();
    // while (it.hasNext()) {
    //     System.out.print(it.next());
    // }
}
    
}
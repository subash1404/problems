import java.util.*;

//this was asked in tech hr interview

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
       while (!q1.isEmpty()) {
        q2.add(q1.remove());
       }
       q1.add(x);
       while (!q2.isEmpty()) {
        q1.add(q2.remove());
       }
    }
    
    public int pop() {
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack s = new MyStack();
        System.out.println("Menu: \n1.Push \n2.Pop \n3.Top \n4.Is Empty \n5.Exit");
        int ch = 0;
        while(ch != 5 ){
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter new element: ");
                    int n = sc.nextInt();
                    s.push(n);
                    System.out.println("added");
                    break;
                case 2:
                    try{
                        System.out.println("Element removed: "+s.pop());
                    }catch(NoSuchElementException e){
                        System.err.println("Stack is empty");
                    }
                    break;
                case 3:
                    System.out.println("Element at top: "+s.top());
                    break;
                case 4:
                    if(s.empty()) System.out.println("Stack is empty");
                    else System.out.println("Stack is not empty");
                    break;
                default:
                 System.out.println("Wrong Input");
                    break;
            }
        }
        sc.close();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
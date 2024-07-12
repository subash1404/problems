import java.util.Scanner;
import java.util.Stack;

class MyQueue{
    Stack<Integer> s1;
    Stack<Integer> s2;

    MyQueue(){
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    void add(int ele){
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(ele);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    int remove(){
        return s1.pop();
    }

    int peek(){
        return s1.peek();
    }

    boolean isEmpty(){
        return s1.isEmpty();
    }
}

public class QueueUsingStack {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyQueue q = new MyQueue();
        System.out.println("Menu: \n1.Add \n2.Remove \n3.Peek \n4.Is Empty \n5.Exit");
        int ch = 0;
        while(ch != 5 ){
            System.out.print("Enter choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Enter new element: ");
                    int n = sc.nextInt();
                    q.add(n);
                    System.out.println("added");
                    break;
                case 2:
                    System.out.println("Element removed: "+q.remove());
                    
                    break;
                case 3:
                    System.out.println("Element at front: "+q.peek());
                    break;
                case 4:
                    if(q.isEmpty()) System.out.println("Queue is empty");
                    else System.out.println("Queue is not empty");
                    break;
                case 5:
                System.out.println("Existing");
                default:
                 System.out.println("Wrong Input");
                    break;
            }
        }
        sc.close();
    }
}

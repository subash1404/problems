package Migration;
import java.util.Stack;

class NextLargestElement {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {
        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();

        // Iterate through the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack until we find a greater element or the stack is
            // empty
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If the stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                res[i] = stack.peek();
            } else {
                // If the stack is empty, there is no greater element
                res[i] = -1;
            }

            // Push the current element onto the stack
            stack.push(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        long[] arr = { 4, 5, 2, 25 };
        int n = arr.length;

        long[] result = nextLargerElement(arr, n);

        for (long num : result) {
            System.out.print(num + " ");
        }
        // Output should be: 5 25 25 -1
    }
}

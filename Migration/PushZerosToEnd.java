package Migration;
// Given an array arr[] of n positive integers. Push all the zeros of the given array 
//to the right end of the array while maintaining the order of non-zero elements. 
//Do the mentioned change in the array in-place.

// Example 1:

// Input:
// N = 5
// Arr[] = {3, 5, 0, 0, 4}
// Output: 3 5 4 0 0
// Explanation: The non-zero elements
// preserve their order while the 0
// elements are moved to the right.
public class PushZerosToEnd {
    void pushZerosToEnd(int[] arr, int n) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[index] = arr[i];
                index++;
            }
        }
        while (index < n) {
            arr[index] = 0;
            index++;
        }
    }
}

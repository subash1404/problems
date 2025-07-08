package Migration;
import java.util.Scanner;

public class NextPermutation {
    // A brute force soln would be to find all the possible combinations in a sorted order using recursion
    // and store them in an array or something. then simply return the next index of the given input
    // this would take a very large TC (N! * N) for n = 15 -> TC = 15^10(approx)

    // Optimal
    static public void nextPermutation(int[] arr) {
        int n = arr.length;
        int ind = -1;
        // Find the breakpoint, the point where the dip happens
        // the array before the breakpoint will be fixed and we will not disturb it
        // n-2 is the point where the dip can start to happen
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                ind = i;
                break;
            }
        }
        // if no dips are found , this is the largest possible permutation 
        // and just reversing the arr will give the answer (minimum possible permutation) 
        if (ind == -1) {
            int i = 0, j = n - 1;
            while (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            return;
        }
        // then we have to find a element to swap with the ind which is just greater than the arr[ind]
        for (int i = n - 1; i >= 0; i--) {
            if (arr[ind] < arr[i]) {
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        // we have to basically sort the arr from ind+1 -> n
        // as the array from ind+1 -> n was already in decreasing order(because we found the dip in the index ony) so just reverse it
        int i = ind + 1, j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    nextPermutation(arr);
    for(int i : arr){
        System.out.print(i+" ");
    }
}
}

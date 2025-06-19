package Migration;
import java.util.*;
public class GapMethod {
    static void swap(int[] arr1,int[] arr2,int ind1,int ind2){
        if(arr1[ind1] > arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    public static void sort(int arr1[],int arr2[],int n,int m){
        int len = n+m;
        int gap = (len/2) + (len%2); // Keep the gap at the center at start
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                if(left < n && right >=  n){ // For cases where the left is at arr1 and right is at arr2
                    swap(arr1,arr2,left,right-n);
                }else if(left >= n){ // For cases where left and right are at arr2
                    swap(arr2,arr2,left-n,right-n);
                }else{ // For cases where left and right are at arr1
                    swap(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            if(gap == 1) break; // If gap becomes 1 (which it always will), it runs on a infinite loop, so break there
            gap = (gap/2) + (gap%2); // divide the gap by 2 for each iteration, gap%2 is used to take the ceil of the operation
            // If we just use gap/2 we will miss the crucial last pass where we miss the final adjustments when a odd number comes
        }
    }

    /*
     * Gap Method visualization
     * Initial arrays:
     * arr1 = [1, 4, 7, 8, 10]
     * arr2 = [2, 3, 9]
     * 
     * n = 5 (arr1 size)
     * m = 3 (arr2 size)
     * total length = n + m = 8
     * Initial gap = (8 / 2) + (8 % 2) = 4
     * 
     * Index pairs:
     * (0,4) → arr1[0]=1 & arr1[4]=10 (No swap)
     * (1,5) → arr1[1]=4 & arr2[0]=2 (Swap → arr1[1]=2, arr2[0]=4)
     * (2,6) → arr1[2]=7 & arr2[1]=3 (Swap → arr1[2]=3, arr2[1]=7)
     * (3,7) → arr1[3]=8 & arr2[2]=9 (No swap)
     * 
     * Arrays after gap=4:
     * arr1 = [1, 2, 3, 8, 10]
     * arr2 = [4, 7, 9]
     * 
     * Index pairs:
     * (0,2) → arr1[0]=1 & arr1[2]=3 (No swap)
     * (1,3) → arr1[1]=2 & arr1[3]=8 (No swap)
     * (2,4) → arr1[2]=3 & arr1[4]=10 (No swap)
     * (3,5) → arr1[3]=8 & arr2[0]=4 (Swap → arr1[3]=4, arr2[0]=8)
     * (4,6) → arr1[4]=10 & arr2[1]=7 (Swap → arr1[4]=7, arr2[1]=10)
     * (5,7) → arr2[0]=8 & arr2[2]=9 (No swap)
     * 
     * Arrays after gap=2:
     * arr1 = [1, 2, 3, 4, 7]
     * arr2 = [8, 10, 9]
     * 
     * Index pairs:
     * (0,1) → arr1[0]=1 & arr1[1]=2 (No swap)
     * (1,2) → arr1[1]=2 & arr1[2]=3 (No swap)
     * (2,3) → arr1[2]=3 & arr1[3]=4 (No swap)
     * (3,4) → arr1[3]=4 & arr1[4]=7 (No swap)
     * (4,5) → arr1[4]=7 & arr2[0]=8 (No swap)
     * (5,6) → arr2[0]=8 & arr2[1]=10 (No swap)
     * (6,7) → arr2[1]=10 & arr2[2]=9 (Swap → arr2[1]=9, arr2[2]=10)
     * 
     * Final arrays:
     * arr1 = [1, 2, 3, 4, 7]
     * arr2 = [8, 9, 10]
     *  
     */



    /*
     * Another optimal solution for sorting 2 arrays without extra space
     * given sorted arrays arr1 (size m) and arr2(size n) [1 5 6] [2 3]
     * left -> m-1, right -> 0 (we are starting from the largest element of the
     * first array and smallest element of the second array)
     * if (arr1[left] > arr[right]) swap (because larger elements are supposed to
     * be on the second array) then left-- ,right++
     * 
     * Iteration 1:
     * [1 5 6] [2 3] since arr1[left] > arr2[right] swap
     * L R
     * 
     * Iteration 2:
     * [1 5 2] [6 3] since arr1[left] > arr2[right] swap
     * L R
     * 
     * [1 3 2] [6 5] since arr1[left] > arr2[right] swap
     * since right has reached the end, we are sure that the smaller numbers are on the arr1 and the larger numbers are on the arr2.
     * In case arr1[left] < arr2[right], we can break the loop because the elements for the next iteration from the arr1 is small and
     * the elements for the next iteration from the arr2 is large
     * Now sort the arrays individually
     */



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        sort(arr1, arr2, n1, n2);

        // Output the sorted arrays
        Arrays.stream(arr1).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
    }
}
package Migration;
public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    static int partition(int[] arr,int low,int high){
        // Pick a pivot element
        int pivot = low,i=low,j=high;
        while(i < j){
            // From left find a element which is greater than the pivot
            while(arr[i] <= arr[pivot] && i <= high) i++;
            // From right find a element which is smaller than the pivot
            while(arr[j] > arr[pivot] && j >= low) j--;
            // When both elements are found, we swap them
            if(i < j){
                swap(arr, i, j);
            }
            // Repeat this until i < j
        }
        // When at the point i has crossed j we are at the point where all the elements to the left of i are smaller 
        // and all the elements to the right of j are larger than the pivot
        // ATP, we swap the pivot and the element at j
        swap(arr, low, j);
        // Return the partition index
        return j;
    }
    static void quickSort(int[] arr,int low,int high){
        if(low < high){
        // Find the partition index by placing the element at the right place
        // Since the partition element is at the right place, pass the left and right array recursively
        // Recursion breaks at low >= high, when there is only one element left 
        int partIndex = partition(arr, low, high);
        quickSort(arr, low, partIndex-1);
        quickSort(arr, partIndex+1, high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,4,2,3,10,9,12};
        quickSort(arr, 0, 7);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}

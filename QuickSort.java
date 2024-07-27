public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        arr[i] = (arr[i] + arr[j]) - (arr[j] = arr[i]);
    }
    static int partition(int[] arr,int low,int high){
        int pivot = low,i=low,j=high;
        while(i < j){
            while(arr[i] <= arr[pivot] && i <= high) i++;
            while(arr[j] > arr[pivot] && j >= low) j--;
            if(i < j){
                swap(arr, i, j);
            }
        }
        swap(arr, low, j);
        return j;
    }
    static void quickSort(int[] arr,int low,int high){
        if(low < high){
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

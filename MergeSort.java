public class MergeSort {
    static public void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[low+(high-low)+1];
        int left = low;
        int right = mid+1;
        int index = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[index++] = arr[left++];
            }else{
                temp[index++] = arr[right++];
            }
        }
        while(left <= mid){
            temp[index++] = arr[left++];
        }
        while(right <= high){
            temp[index++] = arr[right++];
        }
        for(int i=low;i<=high;i++){
            arr[i] = temp[i-low];
        }
    }
    static public void mergeSort(int arr[],int low,int high){
        if(low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,2,3,7,8,9};
        mergeSort(arr, 0, 8);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}

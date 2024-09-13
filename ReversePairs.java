public class ReversePairs {
    public static void merge(int[] arr,int low,int mid,int high){
        int index = 0;
        int[] temp = new int[high - low + 1];
        int i = low,j=mid+1;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
            }
        }
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while(j <= high){
            temp[index++] = arr[j++];
        }
        // for(int k=0;k<temp.length;k++){
        //     arr[k+low] = temp[k];
        // }
        System.arraycopy(temp, 0, arr, low, temp.length);
    }
    public static int countPairs(int[] arr,int low,int mid,int high){
        int right = mid+1;
        int cnt = 0;
        for(int i = low; i <= mid; i++){
            while(right <= high && (long)arr[i] > 2L * arr[right]) right++;
            cnt += right - (mid + 1);
        }
        return cnt;
    }
    public static int mergeSort(int[] arr,int low,int high){
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr,low,mid);
        cnt += mergeSort(arr,mid+1,high);
        cnt += countPairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }
    public static int reversePairs(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        return mergeSort(nums,0,nums.length-1);
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 6, 2, 3, 7, 8, 9 };
        System.out.println(reversePairs(arr));
    }
}

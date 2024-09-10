public class CountInversions {
    public static int merge(long[] arr, int low, int mid, int high) {
        long[] temp = new long[high - low + 1];
        int cnt = 0;
        int i = low, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                cnt += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= high) {
            temp[index++] = arr[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[x + low] = temp[x];
        }
        return cnt;
    }

    public static int mergeSort(long[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid);
        cnt += mergeSort(arr, mid + 1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }

    public static long inversionCount(long arr[]) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        long[] arr = { 1, 4, 5, 6, 2, 3, 7, 8, 9 };
        System.out.println(inversionCount(arr));
    }
}

public class SplitArrayLargestSum {
    public static boolean isSum(int[] arr, int k, int sum) {
        int arrSum = 0;
        for (int i : arr) {
            if (arrSum + i > sum) {
                k--;
                arrSum = i;
            } else {
                arrSum += i;
            }
        }
        return k >= 1; // This means that the iteration got over before array got split into k parts so we have to reduce the sum range
        // If it is false there are remaining elements in the array after the array got split into k parts so we have to increase the sum range 
    }

    public static int splitArray(int[] arr, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i : arr) {
            high += i;
            if (i > low)
                low = i;
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isSum(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 6, 2, 3, 7, 8, 9 };
        System.out.println(splitArray(arr, 2));
    }
}

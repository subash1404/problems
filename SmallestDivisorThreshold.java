public class SmallestDivisorThreshold {
    public static int divideArr(int arr[], int x) {
        int sum = 0;
        for (int i : arr) {
            // sum += Math.ceil((double)arr[i] /(double)x);
            sum += (i + x - 1) / x;
        }
        return sum;
    }

    public static int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max)
                max = i;
        }
        int low = 1, high = max;

        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = divideArr(nums, mid);
            if (sum <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        System.out.println(smallestDivisor(arr,6));
        
    }
}

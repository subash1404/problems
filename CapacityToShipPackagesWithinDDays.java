public class CapacityToShipPackagesWithinDDays {
    public static boolean isPossible(int[] arr, int days, int capacity) {
        int capacitySum = 0;
        int daysCount = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] > capacity)
                return false;
            ;
            if ((capacitySum + arr[i]) > capacity) {
                daysCount++;
                capacitySum = 0;
            } else {
                capacitySum += arr[i];
                i++;
            }
        }
        if (capacitySum != 0)
            daysCount++;
        return daysCount <= days;
    }

    public static int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int i : weights) {
            sum += i;
        }
        int low = 1, high = sum;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(shipWithinDays(arr, 5));
    }
}
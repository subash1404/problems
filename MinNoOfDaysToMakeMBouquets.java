public class MinNoOfDaysToMakeMBouquets {
    public static boolean calcDays(int[] arr, int m, int k, int day) {
        int count = 0;
        int noOfBk = 0;
        for (int i : arr) {
            if (i <= day) {
                count++;
            } else {
                noOfBk += count / k;
                count = 0;
            }
        }
        noOfBk += count / k;
        return noOfBk >= m;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long x = m * k;
        if (x > bloomDay.length)
            return -1;
        int ans = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : bloomDay) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        int low = min, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (calcDays(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 10, 3, 10, 2 };
        System.out.println(minDays(arr, 3, 1));
    }
}
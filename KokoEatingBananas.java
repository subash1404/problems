public class KokoEatingBananas {
    public static long calcHours(int[] arr, int n) {
        long hours = 0;
        for (int i : arr) {
            hours += (i + n - 1) / n;
        }
        return hours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            if (i > max)
                max = i;
        }
        int low = 1, high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            long hours = calcHours(piles, mid);
            if (hours <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println(minEatingSpeed(arr, 8));
    }
}

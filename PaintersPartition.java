import java.util.ArrayList;
import java.util.Collections;

public class PaintersPartition {
    public static boolean isPossible(ArrayList<Integer> arr, int k, int time) {
        int timeSum = 0;
        for (int i : arr) {
            if(i > time) return false;
            if (timeSum + i > time) {
                k--;
                timeSum = i;
            } else {
                timeSum += i;
            }
        }
        return k >= 1;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.min(boards);
        int high = 0;
        for (int i : boards) {
            high += i;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(boards, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(10);
        arr.add(4);
        System.out.println(findLargestMinDistance(arr, 4));
    }
}

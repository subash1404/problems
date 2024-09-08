import java.util.ArrayList;
import java.util.Collections;

public class AllocateBooks {
    public static boolean isPossible(ArrayList<Integer> arr, int m, int pages) {
        int pageSum = 0;
        int students = 1;
        for (int i : arr) {
            if (i > pages)
                return false;
            if (pageSum + i > pages) { // pageSum + i >= pages is wrong because the book will not get allocated to the student
                students++;
                pageSum = i;
                if (students > m)
                    return false;
            } else {
                pageSum += i;
            }
        }
        return true;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {
        if (m > n)
            return -1;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        int low = Collections.max(arr), high = sum;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

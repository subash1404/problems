import java.util.*;

public class ElemFreq {
    public static Map<Integer, Integer> countFreq(int[] arr, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        return freq;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Integer, Integer> freq = countFreq(arr, n);
        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;
        for (int i : freq.keySet()) {
            if (freq.get(i) < low) {
                low = freq.get(i);
            }
            if (freq.get(i) > high) {
                high = freq.get(i);
            }
            System.out.println("High :" + high);
            System.out.println("Low :" + low);

            // System.out.println(i+" : "+freq.get(i)); Only this line for elem frequency
        }

    }
}

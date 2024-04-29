import java.util.*;

class MajorityElement {
    static public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int majorityValue = Integer.MIN_VALUE;
        int majorityElement = 0;
        for (int i : map.keySet()) {
            if (map.get(i) > majorityValue) {
                majorityElement = i;
                majorityValue = map.get(i);
            }
        }
        return majorityElement;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr));
    }
}
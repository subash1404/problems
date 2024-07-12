import java.util.*;

public class FourSum {
    static List<List<Integer>> calc(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<List<Integer>>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if (set.contains(target - sum)) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(target - sum);
                        ans.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        List<List<Integer>> ans2 = new ArrayList<>(ans);
        return ans2;
    }

    static public List<List<Integer>> fourSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1])
                            k++;
                        while (k < l && arr[l] == arr[l + 1])
                            l--;
                    } else if (sum > target)
                        l--;
                    else
                        k++;

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> list2 = calc(arr, target);
        List<List<Integer>> list = fourSum2(arr, target);
        for (List<Integer> it : list) {
            for (int i = 0; i < it.size(); i++) {
                System.out.print(it.get(i) + " ");
            }
            System.out.println();
        }
    }
}

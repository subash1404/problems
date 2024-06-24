import java.util.*;
public class ArrayLeader {
    static ArrayList<Integer> leaders(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader)
                ans.add(arr[i]);
        }
        ans.add(arr[n - 1]);
        return ans;
    }
    //Optimal
    static ArrayList<Integer> leaders2(int n, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] >= max) {
                ans.add(0, arr[i]);
                max = arr[i];
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(leaders2(n,arr));
    }
}
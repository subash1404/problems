import java.util.HashSet;
import java.util.Scanner;

public class ContainsDuplicate {
    static public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
      for(int i:nums){
        if(!set.add(i)){
            return true;
        }
      }
      return false;
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(containsDuplicate(arr));
    }
}

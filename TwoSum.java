//Two Sum
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    static public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> ans = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int compliment = target - nums[i];
            if(ans.containsKey(compliment) && ans.get(compliment) != i){
                return new int[]{i,ans.get(compliment)};
            }
            ans.put(nums[i],i);
        }
        return new int[]{};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = twoSum(arr,target);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        // Arrays.stream(result).forEach(System.out::print);
    }
}

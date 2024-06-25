import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecSeq {
    // Brute force would be to use O(n^2)

    //Better
    static public int longestConsecutive(int[] nums) {
        int longest = 1,count=1,lastSeen = Integer.MIN_VALUE;
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSeen){
                count++;
                lastSeen = nums[i];
            }else if(nums[i] != lastSeen){
                count = 1;
                lastSeen = nums[i];
            }
            longest = Math.max(longest,count);
        }
        return longest;
    }
    //Optimal
    static public int longestConsecutive2(int[] nums) {
        int longest = 1, count = 0;
        if (nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int x = i;
                count = 1;
                while (set.contains(x + 1)) {
                    count++;
                    x++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    System.out.println(longestConsecutive(arr));
    System.out.println(longestConsecutive2(arr));
}

}

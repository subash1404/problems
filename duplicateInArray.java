//Find the duplicate elements that appears once or twice in array of size n and the elements range is [1,n]

import java.util.*;
class DuplicateInArray {
    static public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] < 0) {
                ans.add(x);
            }
            nums[x - 1] *= -1;
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

        List<Integer> duplicates = findDuplicates(arr); // Get duplicates

        for (int d : duplicates) {
            System.out.print(d + " "); // Print duplicates
        }
    }
}
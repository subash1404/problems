import java.util.Scanner;

class Solution {
    //If the array is not sorted
    // static public HashSet<Integer> removeDuplicates(int[] nums) {
    //     HashSet<Integer> set = new HashSet<>();
    //     for (int i : nums) {
    //         set.add(i);
    //     }
    //     return set;
    // }
    
    //If the array is sorted, (less time and space complexity)
    static public int removeDuplicates(int[] nums) {
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(arr));
    }
}
import java.util.*;

import javax.swing.text.html.HTMLDocument.Iterator;

public class ThreeSum {
    static public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] < 0) j++;
                else if(nums[i] + nums[j] + nums[k] > 0) k--;
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j < k && nums[j] != nums[j-1]) j++;
                    while(j < k && nums[k] != nums[k-1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        List<List<Integer>> ans = threeSum(arr);
        System.out.println(ans);
        sc.close();
    }

}

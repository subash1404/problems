import java.util.*;

public class MajorityElement2 {
    static public List<Integer> majorityElement(int[] nums) {
        int mini = (nums.length / 3) + 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) == mini) ls.add(nums[i]);
            
            // For any given n size there cant be more than two majority elements
            // n = 100 , n/3+1 = 34, 34+34+34 > 100
            if(ls.size() == 2) break;
        }
        return ls;
    }
    // Optimal Approach (Extension of Moore's algorithm)
    static public List<Integer> majorityElement2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int mini = (nums.length / 3) + 1;
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (ele1 == i)
                cnt1++;
            else if (ele2 == i)
                cnt2++;
        }
        if (cnt1 >= mini)
            list.add(ele1);
        if (cnt2 >= mini)
            list.add(ele2);
        return list;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(majorityElement(arr));
        System.out.println(majorityElement2(arr));
    }
}

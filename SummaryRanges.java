import java.util.List;
import java.util.ArrayList;
/* You are given a sorted unique integer array nums.

A range [a,b] is the set of all integers from a to b (inclusive).
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
 */
public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int left = 0, right = 0;

        while(right < nums.length){
            if(!(right < nums.length - 1 && nums[right+1] == nums[right] + 1)){
                String s = String.valueOf(nums[left]);
                if(left != right) s += "->" + nums[right];
                result.add(s);
                left = right + 1;
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {0,2,3,4,6,7};
        System.out.println(summaryRanges(arr));
    }
}

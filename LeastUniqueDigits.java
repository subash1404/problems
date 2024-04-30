// Given an array of integers arr and an integer k. Find the least number of unique integers after removing 
//exactly k elements.
// Example 1:

// Input: arr = [5,5,4], k = 1
// Output: 1
// Explanation: Remove the single 4, only 5 is left.
// Example 2:
// Input: arr = [4,3,1,1,3,3,2], k = 3
// Output: 2
// Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.
 import java.util.*;
public class LeastUniqueDigits {
    static int leastDigits(int arr[],int k){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        List<Map.Entry<Integer,Integer>> elements = new ArrayList<>(map.entrySet());
        elements.sort((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer,Integer> entry : elements){
            if(entry.getValue() <= k){
                k -= entry.getValue();
                map.remove(entry.getKey());
            }else{
                break;
            }
        }
        return map.size();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(leastDigits(arr, k));
    }
}

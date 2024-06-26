
import java.util.*;

public class LongestSubArraySumEqualsK {
    // Brute force soln would be to generate all the possible subarrays O(n^3)
    // for(i=0 -> n){
    //    for(j=i -> n){
    //      for(k=i -> j){
    //          sum += arr[k];
    //      }
    //      if(sum == k) maxLen = Math.max(maxLen,j-1=i);
    //      }
    //  }

    // We can eliminate the k loop by just adding the j element O(n^2)
    // for(i=0 -> n){
    //  int sum =0;
    //  for(j=i -> n){
    //      sum+=arr[j];
    // if(sum == k) maxLen = Math.max(maxLen,j-1=i);
    //  }
    // }

    // Optimal approach for array with zeros, positives and negatives
    static int getLongestSubarray(int[] arr, int k){
        int maxLen =0,sum=0;
        HashMap<Integer,Integer> sumMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            // Calculate prefix sum
            sum += arr[i];
            
            // If sum equals target assign it to the maxLen
            if(sum == k){
                maxLen = Math.max(maxLen, i+1);
            }

            int rem = sum - k;
            
            // If rem is present in the hashmap, calculate the length of the subarray and assign it to maxLen
            if(sumMap.containsKey(rem)){
                int len = i - sumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // If the sum is already present in the map, dont add it because we want the maximum subarray
            // check for this case [2,0,0,3] and k =3
            // if we add in the map while sum already exists answer would be 1
            if(!sumMap.containsKey(sum)){
                sumMap.put(sum,i);
            }
        }
        return maxLen;
    }
    // Optimal soln if arr contains zeros and positives
    static int getLongestSubarray2(int[] arr,int k){
        int i=0,j=0,sum=0,maxLen=0;
        // int[] a = { 1, 2, 3, 1, 1, 1, 1 };
        while(j < arr.length && i<arr.length){
            sum =0;
            for(int x=i;x<=j;x++){
            sum += arr[x];
            }
            System.out.println(sum+" "+i+" "+j);
            if(sum == k) {
                maxLen = Math.max(maxLen, j - i+1);
                j++;
            }
            else if(sum > k) i++;
            else if(sum < k) j++;
        }
        return maxLen;
    }
    // sliding window
    static int getLongestSubarray3(int[] arr, int k) {
        int i = 0, j = 0, sum = 0, maxLen = 0,count=0;
        while (j < arr.length) {
            sum += arr[j];
            while (sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
                count++;
            }
            j++;

        }
        System.out.println(count);
        return maxLen;
    }
    // Number of subarrays
    static int countSubArrays(int[] arr, int k) {
        int sum = 0,count=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            int rem = sum - k;
            // we basically check the sum - k part for the number of subarrays present
            // (reverse engineering)
            count += map.getOrDefault(rem, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        // int[] a = {1,2,3,4};
        int[] a = { 3, 1, 1, 5, 5, 10 };
        int[] a2 = { -13, 0, 6, 15, 16, 2,15,-12,17,-16,0,-3,19,-3,2,-9,-6};
        int k = 10;
        // int len = getLongestSubarray(a2, k);
        int len = getLongestSubarray2(a, k);
        int len2 = getLongestSubarray3(a, k);
        int count1 = countSubArrays(a, k);
        System.out.println("The length of the longest subarray is: " + len);
        System.out.println("The length of the longest subarray is: " + len2);
        System.out.println("The count of subarrays is: " + count1);
    }
}

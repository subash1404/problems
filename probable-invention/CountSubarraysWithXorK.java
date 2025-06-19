import java.util.*;

public class CountSubarraysWithXorK {
    public static int countSubArrays(int[] arr,int k){
        int count = 0;
        // The hashmap is for storing the pre XOR
        Map<Integer,Integer> map = new HashMap<>();
        // 0 is addded to the map to handle cases where the entire array is the subarray
        // (while iterating, 0 is used when the subarray wih XOR k is the entire array till i (selected index))
        map.put(0,1);
        int xr = 0;
        for(int i : arr){
            xr ^= i;
            // Store the pre XOR in the map, if the pre XOR already exists increment the count
            map.put(xr,map.getOrDefault(xr, 0)+1);
            // Here, we are looking for a XOR k, and we have the track of current XOR, which means that
            // if we have a pre XOR of x (xr ^ k) somewhere in the array we can say that there exists a subarray with XOR k

            // Given an array 4 2 2 6 , target XOR = 6
            // if we are the last index, xr = 2, we have to search if a subarray with XOR 4 (x = xr ^ k [2 ^6]) have appeared before
            // we would have stored that subarrays with XOR 4 has appeared 2 times(iteration 0 and 2)
            // so we know that there are two subarrays with XOR ending at 6 (2, 2, 6) and (6)
            int x = xr ^ k;
            if(map.containsKey(x)){
                count += map.get(x);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // int[] arr = {4, 2, 2, 6, 4};
        int[] arr = {5, 6, 7, 8, 9};
        System.out.println(countSubArrays(arr, 5));
    }
}

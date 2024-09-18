import java.util.*;

public class CountSubarraysWithXorK {
    public static int countSubArrays(int[] arr,int k){
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int xr = 0;
        for(int i : arr){
            xr ^= i;
            map.put(xr,map.getOrDefault(xr, 0)+1);
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

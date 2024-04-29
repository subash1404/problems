//Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. 
//First array has one element extra added in between. Find the index of the extra element.
import java.util.*;
class Solution {
    public int findExtra(int a[], int b[], int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(b[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(a[i]))
                map.put(-1, i);

        }
        for (int i : map.keySet()) {
            if (i == -1) {
                return map.get(i);
            }
        }
        return 0;
    }
}
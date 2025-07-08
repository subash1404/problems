package Migration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0]; // Start with the first interval

        for (int i = 1; i < intervals.length; i++) {
            // If current interval overlaps with the previous
            if (intervals[i][0] <= prev[1]) {
                // Merge by updating the end of prev
                prev[1] = Math.max(prev[1], intervals[i][1]);
            } else {
                // No overlap, so add prev to the result
                list.add(prev);
                prev = intervals[i]; // Move to the current interval
            }
        }

        // Add the last interval
        list.add(prev);

        return list.toArray(new int[list.size()][]);
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            arr[i][j] = sc.nextInt();
        }
        int[][] ans = merge(arr);
        for(int[] i:ans){
            for(int j : i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
        sc.close();
    }
}

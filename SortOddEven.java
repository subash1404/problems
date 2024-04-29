import java.util.*;

public class SortOddEven {
    static public long[] sortIt(long arr[], long n)
    {
        List<Long> oddList = new ArrayList<>();
        List<Long> evenList = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]%2 == 0){
                evenList.add(arr[i]);
            }
            else{
                oddList.add(arr[i]);
            }
        }
        Collections.sort(oddList,Collections.reverseOrder());
        Collections.sort(evenList);
        List<Long> result = new ArrayList<>(oddList);
        result.addAll(evenList);
        for(int i=0;i<n;i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int)n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long[] result = sortIt(arr,n);
        for (long i : result) {
            System.out.print(i + " ");
        }
    }
}

import java.util.*;
public class findDuplicates {
    static List<Integer> findDuplicates(int[] num){
        int n = num.length;
        Set<Integer> visitedSet = new HashSet<>();
        List<Integer> dupList = new ArrayList<>();
        for(int i : num){
            if(visitedSet.contains(i)){
                if(!dupList.contains(i)){
                    dupList.add(i);
                }
            }else{
                visitedSet.add(i);
            }
        }
        return dupList;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<Integer> duplicates = findDuplicates(arr); 

        for (int d : duplicates) {
            System.out.print(d + " ");
        }
    }
}

import java.util.Scanner;

public class NthRoot {
    public static int findNthRoot(int n, int m)
    {
        if(m == 1) return 1;
        int low = 1,high=m/n;
        while(low <= high){
            int mid = (low + high) / 2;
            if(Math.pow(mid,n) == m){
                return mid;
            }else if(Math.pow(mid,n) < m){
                low = mid+1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(findNthRoot(n, m));
        sc.close();
    }
}

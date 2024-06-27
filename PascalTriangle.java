import java.util.*;

public class PascalTriangle {
    static int printElem(int r,int c){
        int res = 1;
        for(int i=0;i<c;i++){ // Forumal for finding an elem in nth row , cth column is nCr = n! / (r! * (n-r)!)
            res = res * (r - i);
            res /= i+1;
        }
        return res;
    }
    static List<Integer> printRow(int r){
        List<Integer> list = new ArrayList<>();
        list.add(1); // first elem of all rows is zero
        int res = 1;
        for(int i=1,j=r;i<=r;i++,j--){ // start from 1
            res = (res * j) / i; // simple pattern
            list.add(res);
        }
        return list;
    }
    static List<List<Integer>> printTriangle(int n){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            List<Integer> tempList = printRow(i);
            list.add(tempList);
        }
        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(printElem(r-1,c-1));
        System.out.println(printRow(r-1));
        System.out.println(printTriangle(r));

    }
}

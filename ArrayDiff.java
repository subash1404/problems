//Sum of Diff of columns in an array + Sum of Diff of columns in another array
// 1 2 3 4
// 2 2 2 2
// 5 4 3 1

// 4 3 2 1
// 5 3 2 0
// 6 3 2 1
//op : 25
import java.util.*;
public class ArrayDiff {
    public static void main(String[] args){
        Scanner sc =  new Scanner(System.in);
        int m =  sc.nextInt();
        int n =  sc.nextInt();
        int[][] arr1 = new int[m][n];
        int[][] arr2 = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr2[i][j] = sc.nextInt();
            }
        }
        int add1=0;
        for(int i=0;i<n;i++){
            int sub = arr1[0][i]-arr1[1][i];
            for(int j=2;j<m;j++){
                sub =(sub - arr1[j][i]);
            }
            System.out.println(i+" : "+Math.abs(sub));
            add1+=Math.abs(sub);
        }
        int add2=0;
        for(int i=0;i<n;i++){
            int sub = (arr2[0][i]-arr2[1][i]);
            for(int j=2;j<m;j++){
                sub=(sub - arr2[j][i]);
            }
            System.out.println(i+" : "+Math.abs(sub));
            add2+=Math.abs(sub);
        }
        System.out.println(add1+add2);
    }
}

//Minimum non negative difference of two arrays

import java.util.Arrays;
import java.util.Scanner;

public class Diff {

    static int minNonNegativeDifference(int[] array1,int array2[]){
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i=0;
        int j=0;
        int minDiff = Integer.MAX_VALUE;
        while(i < array1.length && j < array2.length){
            int diff = array1[i] - array2[j];
            if(diff == 0 ){
                return diff;
            }
            if(diff >=0){
                if(minDiff > diff){
                    minDiff = diff;
                }
                j++;
            }else{
                i++;
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        int[] array1 = new int[n1];
        int[] array2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            array1[i] = sc.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            array2[i] = sc.nextInt();
        }

        int result = minNonNegativeDifference(array1, array2);
        System.out.println("Minimum non-negative difference: " + result);

    }
}

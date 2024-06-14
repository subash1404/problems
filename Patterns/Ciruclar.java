package Patterns;

import java.util.*;
public class Ciruclar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = 2*(n-1)+1;
        int[][] arr = new int[size][size];
        int middle = size/2;
        int elem = n;
        for(int i=0;i<size/2;i++){
            for(int j=i;j<size - i;j++){
                arr[i][j] = elem;
                arr[j][i] = elem;
            }
            elem--;
        }
        elem = n;
        // int it = 0;
        // for(int i=size-1;i>middle;i--){
        //     for(int j=size-1-it;j>=it;j--){
        //         arr[i][j] = elem;
        //         arr[j][i] = elem;
        //     }
        //     it++;
        //     elem--;
        // }
        arr[middle][middle] = elem;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size ; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}

// Given two sorted arrays of size n and m respectively,find their union.The Union of two arrays can be defined 
//as the common and distinct elements in the two arrays.Return the elements in sorted order.

// Example 1:

// Input:n=5,arr1[]={1,2,3,4,5}m=5,arr2[]={1,2,3,6,7}Output:1 2 3 4 5 6 7 Explanation:Distinct elements 
// including both the arrays are:1 2 3 4 5 6 7.

import java.util.ArrayList;
import java.util.Scanner;

public class UnionArray {
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0,j=0;
        while(i < n && j < m){
            if(arr1[i] == arr2[j]){
                if(!list.contains(arr1[i])) list.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i] > arr2[j]){
                if(!list.contains(arr2[j])) list.add(arr2[j]);
                j++;
            }else if(arr2[j] > arr1[i]){
                if(!list.contains(arr1[i])) list.add(arr1[i]);
                i++;
            }
        }
        while(i < n){
            if(!list.contains(arr1[i])){
                list.add(arr1[i]);
            }
            i++;
        }
        while(j < m){
            if(!list.contains(arr2[j])){
                list.add(arr2[j]);
            }
            j++;
        }
        return list;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int m = sc.nextInt();
        int[] arr2 = new int[m];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = findUnion(arr, arr2, n, m);
        System.out.println(ans);
    }
}

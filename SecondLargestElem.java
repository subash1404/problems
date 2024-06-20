// Given an array Arr of size N,print the second largest distinct element from an array.If the second largest
// element doesn'texist then return-1.

// Example 1:

// Input:N=6 Arr[]={12,35,1,10,34,1}Output:34 Explanation:The largest element of the array is 35 and 
//the second largest element is 34.

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestElem {
    static int print2largest(int arr[], int n) {
        if(n==1) return -1;
        int ans =-1;
        Arrays.sort(arr);
        for(int i=n-2;i>=0;i--){
            if(arr[i] != arr[n-1]){
                ans = arr[i];
                break;
            }
        }
        return ans;
    }

static int print2largest2(int arr[], int n) {
        if(n==1) return -1;
        int ans =-1;
        boolean maxFound = false;
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i] > max1 && arr[i] < max){
                max1 = arr[i];
                maxFound = true;
            }
        }
        return maxFound ? max1 : -1;
    }

static int print2largest3(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        boolean allSame = true;
        for(int i=0;i<n;i++){
            if(arr[i] > max){
                max1 = max;
                max = arr[i];
            }else if(arr[i] > max1 && arr[i] < max){
                max1 = arr[i];
            }
            if(arr[i] != arr[0]){
                allSame = false;
            }
        }
        return allSame ? -1 : max1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(print2largest(arr, n));
        System.out.println(print2largest2(arr, n));
        System.out.println(print2largest3(arr, n));
    }
}

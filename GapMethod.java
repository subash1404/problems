import java.util.*;
public class GapMethod {
    static void swap(int[] arr1,int[] arr2,int ind1,int ind2){
        if(arr1[ind1] > arr2[ind2]){
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }
    }
    public static void sort(int arr1[],int arr2[],int n,int m){
        int len = n+m;
        int gap = (len/2) + (len%2);
        while(gap > 0){
            int left = 0;
            int right = left+gap;
            while(right < len){
                if(left < n && right >=  n){
                    swap(arr1,arr2,left,right-n);
                }else if(left >= n){
                    swap(arr2,arr2,left-n,right-n);
                }else{
                    swap(arr1,arr1,left,right);
                }
                left++;
                right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        sort(arr1, arr2, n1, n2);

        // Output the sorted arrays
        Arrays.stream(arr1).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Arrays.stream(arr2).forEach(x -> System.out.print(x + " "));
    }
}
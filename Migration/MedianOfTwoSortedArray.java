package Migration;
import java.util.Scanner;

public class MedianOfTwoSortedArray {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int ind2 = n / 2;
        int ind1 = ind2 - 1;
        int i = 0, j = 0, cnt = 0;
        int ele1 = -1, ele2 = -1;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                if (ind1 == cnt)
                    ele1 = nums1[i];
                if (ind2 == cnt)
                    ele2 = nums1[i];
                i++;
                cnt++;
            } else {
                if (ind1 == cnt)
                    ele1 = nums2[j];
                if (ind2 == cnt)
                    ele2 = nums2[j];
                j++;
                cnt++;
            }
        }
        while (i < nums1.length) {
            if (ind1 == cnt)
                ele1 = nums1[i];
            if (ind2 == cnt)
                ele2 = nums1[i];
            i++;
            cnt++;
        }
        while (j < nums2.length) {
            if (ind1 == cnt)
                ele1 = nums2[j];
            if (ind2 == cnt)
                ele2 = nums2[j];
            j++;
            cnt++;
        }
        if (n % 2 == 1)
            return (float) ele2;
        else
            return (float) (ele1 + ele2) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
        }
        for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(arr1, arr2));

    }
}

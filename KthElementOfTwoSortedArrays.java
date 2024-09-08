public class KthElementOfTwoSortedArrays {
    public static long kthElement(int k, int arr1[], int arr2[]) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                if (--k == 0)
                    return arr1[i];
                i++;
            } else {
                if (--k == 0)
                    return arr2[j];
                j++;
            }
        }
        for (int x = i; x < arr1.length; x++) {
            if (--k == 0)
                return arr1[x];
        }
        for (int x = j; x < arr2.length; x++) {
            if (--k == 0)
                return arr2[x];
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 3, 5, 7 };
        int[] arr2 = { 3, 7, 8, 9 };
        System.out.println(kthElement(6, arr1, arr2));
    }
}

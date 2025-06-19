class ArrayEqui {
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1)
            return 1;

        long totalSum = 0;
        for (long num : arr)
            totalSum += num;

        long leftSum = 0, rightSum = totalSum;

        for (int i = 0; i < n; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum)
                return i + 1;
            leftSum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        long[] arr = { 1, 3, 5, 2, 2 };
        int n = arr.length;

        int result = equilibriumPoint(arr, n);
        System.out.println(result); // Output: 3
    }
}

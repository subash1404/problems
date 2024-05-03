import java.util.*;

class DiagonalSort {
    static public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int col = 0; col < n; col++) {
            sort(mat, 0, col, m, n);
        }
        for (int row = 1; row < m; row++) {
            sort(mat, row, 0, m, n);
        }
        return mat;
    }

    static void sort(int[][] mat, int row, int col, int m, int n) {
        List<Integer> values = new ArrayList<>();
        int r = row;
        int c = col;
        while (r < m && c < n) {
            values.add(mat[r][c]);
            r++;
            c++;
        }
        Collections.sort(values);
        int index = 0;
        r = row;
        c = col;
        while (r < m && c < n) {
            mat[r][c] = values.get(index++);
            r++;
            c++;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m,n;
        m = sc.nextInt();
        n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j=0;j<n;j++){
            arr[i][j] = sc.nextInt();
            }
        }
        int[][] result = diagonalSort(arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
}
}
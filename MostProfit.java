import java.util.Scanner;

public class MostProfit {
    static public int findJob(int ability, int[] diff, int[] profit) {
        int max = 0;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i] <= ability) {
                max = Math.max(max, profit[i]);
            }
        }
        return max;
    }

    static public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int sum = 0;
        for (int i : worker) {
            sum += findJob(i, difficulty, profit);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] diff = new int[n];
        int[] profit = new int[n];
        int[] workers = new int[n];
        for(int i=0;i<n;i++){
            diff[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            profit[i] = sc.nextInt();
        }
        for(int i=0;i<m;i++){
            workers[i] = sc.nextInt();
        }
        System.out.println(maxProfitAssignment(diff,profit,workers));        
        sc.close();
    }
}

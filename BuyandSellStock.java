import java.util.*;
public class BuyandSellStock {

    static public int maxProfit(int[] prices) {
        int profit = 0;
        int buyPrice = prices[0];
        for(int i=0;i<prices.length;i++){
            if(buyPrice > prices[i])
                buyPrice = prices[i];
            else
                profit = Math.max(profit,prices[i] - buyPrice);
        }
        return profit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxProfit(arr));
    }
}
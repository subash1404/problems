import java.util.*;

public class PrimePairsWithTargetSum {
    static boolean primes[];

    static public void findPrimes(int n) {
        primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        // for (int i = 2; i <= Math.sqrt(n); i++) {
        //     if (primes[i]) {
        //         for (int p = 2; p < n; p++) {
        //             int out = p * i;
        //             if (out > n)
        //                 break;
        //             primes[out] = false;
        //         }
        //     }
        // }
        // Sieve of Eratosthenes algorithm
        for (int i = 2; i * i <= n; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        // This didnt work in leetcode time limit exceeded
        // for(int i = 2;i<=n;i++){
        // int num = i;
        // for(int j=2;j<=i/2;j++){
        // if(num % j == 0)
        // primes[num] = false;
        // }
        // }
        // System.out.println(Arrays.toString(primes));
    }

    static public List<List<Integer>> findPrimePairs(int n) {
        findPrimes(n);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 2; i <= n / 2; i++) {
            int comp = n - i;
            if (primes[i] && primes[comp]) {
                list.add(Arrays.asList(i, comp));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        ansList = findPrimePairs(n);
        System.out.println(ansList);
        sc.close();
    }
}

// Brute Force kinda soln
// public static boolean prime(int n) {
// if (n == 0 || n == 1)
// return false;
// boolean flag = true;
// for (int i = 2; i <= n / 2; i++) {
// if (n % i == 0) {
// return false;
// }
// }
// return flag;
// }

// static public List<List<Integer>> findPrimePairs(int n) {
// List<List<Integer>> ans = new ArrayList<List<Integer>>();
// List<Integer> primes = new ArrayList<>();
// for (int i = 2; i < n; i++) {
// if (prime(i))
// primes.add(i);
// }
// for (int i = 0; i < primes.size(); i++) {
// int comp = n - primes.get(i);
// if (primes.get(i) + primes.get(i) == n) {
// // ans.add(Arrays.asList(2,3));
// ans.add(Arrays.asList(primes.get(i), primes.get(i)));
// } else if (primes.contains(comp) && comp > primes.get(i)) {
// ans.add(Arrays.asList(primes.get(i), comp));
// }
// }
// return ans;
// }

import java.util.*;


public class ShuffleNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        for (int i = 0; i < testCases; i++) {
            String rangeInput = sc.nextLine();
            String[] range = rangeInput.split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            List<Integer> numbers = new ArrayList<>();
            for (int j = start; j <= end; j++) {
                numbers.add(j);
            }

            Collections.shuffle(numbers);
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}

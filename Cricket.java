import java.util.Scanner;

public class Cricket {
    static int[] calc(String str) {
        char[] scores = str.replace(" ", "").toCharArray();
        int[] res = new int[3];
        for (int i = 0; i < res.length; i++) {
            res[i] = 0;
        }
        boolean isFirstPlayer = true;
        for (char score : scores) {
            if (score == 'N' || score == 'W') {
                res[2] += 1;
            }else if(score == '.'){

            }else{
                if(isFirstPlayer){
                    res[0]+= Character.getNumericValue(score);
                    System.out.println("Added "+ Character.getNumericValue(score)+" to play 1");
                }else{
                    res[1]+= Character.getNumericValue(score);
                    System.out.println("Added " + Character.getNumericValue(score) + " to play 2");

                }
                if((int)score %2 != 0){
                    isFirstPlayer = !isFirstPlayer;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] res = calc(str);
        for(int i : res){
            System.out.println(i);
        }
    }
}

import java.util.Scanner;

public class SortColors {
    static void sortColors(int[] nums){
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                nums[mid] = nums[low];
                nums[low] = 0;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                nums[mid] = nums[high];
                high--;
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < nums.length; i++){
            nums[i] = sc.nextInt();
        }

        sortColors(nums);

        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i] + " ");
        }

        sc.close();
    }
}

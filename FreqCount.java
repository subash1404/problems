import java.util.*;
public class FreqCount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : inp.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char key : map.keySet()){
            System.out.println(key+""+map.get(key));
        }
    }
}

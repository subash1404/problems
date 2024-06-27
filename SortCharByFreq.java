import java.util.*;

public class SortCharByFreq {
    static public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y) -> map.get(y) - map.get(x));

        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            pq.add(ch);
            // pq.offer does not throw an exception when unable to add in the queue
            // pq.add throws an illegal state exception when unable to add
        }
        StringBuilder sb = new StringBuilder();
        System.out.println(pq);
        while(!pq.isEmpty()){
            char ch = pq.poll();
            for(int i=0;i<map.get(ch);i++){
                sb.append(ch);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(frequencySort(str));
    }
}

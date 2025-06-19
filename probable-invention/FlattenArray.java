
//Flatten a 2D array
import java.util.*;
import java.util.stream.*;

public class FlattenArray {
    static <T> List<T> flatten(T[][] arrays) {
        List<T> flattenList = new ArrayList<>();
        for (T[] array : arrays) {
            Arrays.stream(array).forEach(flattenList::add);
        }
        return flattenList;
    }

    public static void main(String args[]) {
        Integer[][] arrays = {
                { 1, 2, 3 },
                { 4, 5 },
                { 6, 7, 8, 9 }
        };
        Character[][] arrays1 = {
                { 'a', 'b', 'c' },
                { 'd', 'e' },
                { 'f', 'g', 'h', 'i' }
        };

        // List<Integer> flattenedList = flatten(arrays);
        List<Character> flattenedList = flatten(arrays1);
        // for(int f : flattenedList){
        // System.out.println(f+" ");
        // }
        System.out.println("\n" + flattenedList);
        // flattenedList.forEach(System.out::println);
        // List has a built in foreach method, but array does not
        // Arrays has to be converted to stream to use for each on them
        // Arrays.stream(arr).forEach(System.out::println);
        // or the other method is
        // Arrays.asList(numbers).forEach(System.out::println);
    }
}

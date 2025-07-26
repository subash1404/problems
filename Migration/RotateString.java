package Migration;
public class RotateString {
    static public boolean rotateString(String s, String t) {
        // this soln isnt working
        // if(s.length() != t.length()) return false;
        // char search = s.charAt(0);
        // int index=-1;
        // for(int i=t.length()-1;i>=0;i--){
        // if(t.charAt(i) == search){
        // index = i;
        // break;
        // }
        // }
        // if(index == -1) return false;
        // for(int i=0,j=index;i<s.length();i++,j++){
        // if(s.charAt(i) != t.charAt(j % s.length())) return false;
        // }
        // return true;

    // rotate the array for array.length no of times and see if it matches the goal
    //     public boolean rotateString(String s, String goal) {
    //     if (s.length() != goal.length()) return false;
    //     int length = s.length();
    //     char[] sChars = s.toCharArray();

    //     // Try all possible rotations of the string
    //     for (int rotationCount = 0; rotationCount < length; ++rotationCount) {
    //         // Perform one rotation
    //         sChars = rotateOnce(sChars);
    //         if (new String(sChars).equals(goal)) return true;
    //     }
    //     return false;
    // }

    // private char[] rotateOnce(char[] arr) {
    //     char firstChar = arr[0];
    //     System.arraycopy(arr, 1, arr, 0, arr.length - 1);
    //     arr[arr.length - 1] = firstChar;
    //     return arr;
    // }

        return s.length() == t.length() && (s + s).contains(t);
    }
    public static void main(String[] args) {
        System.out.println(rotateString("sabarees", "eessabar"));
    }
}

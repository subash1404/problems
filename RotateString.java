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

        return s.length() == t.length() && (s + s).contains(t);
    }
    public static void main(String[] args) {
        System.out.println(rotateString("sabarees", "eessabar"));
    }
}

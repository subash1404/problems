class Solution {
    public String countAndSay(int n) {
        String curr="1";
        for(int k=1;k<n;k++){
            String next="";
            int i=0;
            while(i<curr.length()){
                int cc=1;
                while(i<curr.length()-1 && curr.charAt(i)==curr.charAt(i+1)){
                    cc++;
                    i++;
                }
                next+=String.valueOf(cc)+curr.charAt(i);
                i++;
            }
            curr=next;
        }
        return curr;
    }
}

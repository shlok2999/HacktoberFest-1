public class kmpdemo {
    static void kmp(String src,String pat){
        int i = 0;
        int j = 0;
        int[] lps = lps(pat);
        while(i<src.length()){
            if(src.charAt(i)==pat.charAt(j)){
                i++;
                j++;
                if(j==pat.length()){
                    System.out.println("Found at " + (i - pat.length()));
                    j = lps[j-1];
                }
            } else {
                if(j!=0){
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
    }
    public static void main(String[] args) {
        String src = "abcsssssssojp3nro3ro3onro3nronlqnbdiqabccabc";
        String pat = "abc";
        kmp(src, pat);
    }
}
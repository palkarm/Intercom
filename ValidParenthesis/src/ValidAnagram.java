import java.util.Arrays;

public class ValidAnagram {
    public static void main(String args[]){
        anagram("abc","cba");
//        ispalindrome("ama");
    }

//    private static boolean ispalindrome(String str) {
//        if(str==null) return true;
//       for()
//    }

    private static boolean anagram(String s, String t) {
        char c1[] =s.toCharArray ();
        char c2[]=s.toCharArray ();
        Arrays.sort(c1);
        Arrays.sort ( c2 );
        String s1 = String.valueOf ( c1 );
        String s2 = String.valueOf ( c2 );
        return s1.equalsIgnoreCase ( s2 );
    }
}

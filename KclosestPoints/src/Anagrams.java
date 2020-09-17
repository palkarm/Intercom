import java.util.*;

public class Anagrams {
    public static void main(String args[]) {
        String s[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        stringIsAnagram ( s );
    }

    private static List<List<String>> stringIsAnagram(String[] str) {
        Map<String, List> map = new HashMap<> ();
        if (str == null) {
            return new ArrayList<> ();
        }
        for (String s : str) {
            char ca[] = s.toCharArray ();
            Arrays.sort ( ca );
            String key = String.valueOf ( ca );
            if (!map.containsKey ( key )) {
                map.put ( key, new ArrayList () );
              //  System.out.println("Sorted String "+ key);
            }
            map.get ( key ).add ( s );
            //System.out.println("Anagrams "+ map.get ( key ) );

        }
        return new ArrayList( map.values () );
    }
}

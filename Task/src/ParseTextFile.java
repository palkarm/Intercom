import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.nio.file.Path;
import java.util.Map.Entry;

import static java.lang.Integer.*;
import static java.nio.file.Paths.get;
public class ParseTextFile {
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    HashMap<Integer, String> mapCustomer = new HashMap<> ();
    public static void main(String[] args) throws IOException {
        ParseTextFile parseTextFile = new ParseTextFile ( "CustomerList.txt" );
        parseTextFile.parseLineByLine ();
        parseTextFile.sortCustomer ();
    }

public ParseTextFile(String filename) {
        filePath = get ( filename );
    }

    private void parseLineByLine() {
            try (Scanner sc =  new Scanner(filePath, ENCODING.name())){
            while (sc.hasNextLine ()) {
                parseContentInEachLine ( sc.nextLine () );
            }
        } catch (IOException e) {
                e.printStackTrace ();
            }
    }

    private void parseContentInEachLine(String line) {
        //second Scanner to parse the content of each line
        try(Scanner scanner = new Scanner(line)){
            scanner.useDelimiter(",");
            if (scanner.hasNext ()) {
                String latitude = scanner.next ();
                String user_id = scanner.next ();
                String name = scanner.next ();
                String longitude = scanner.next ();
                latitude = latitude.replaceAll ( "[a-zA-Z:\"\\s]", "" ).replaceAll ( "\\p{Ps}", "" );
                longitude = longitude.replaceAll ( "[a-zA-Z:\"\\s]", "" ).replaceAll ( "}$", "" );

                if (getDistance ( latitude, longitude, 53.339428, -6.257664 ) == true) {
                    // System.out.println(name.trim().substring ( 9) + " "+  ", " + " "+user_id.trim().substring ( 11 ));

                    mapCustomer.put ( Integer.parseInt ( user_id.trim ().substring ( 11 ) ), name.trim ().substring ( 9 ) );
                }
            } else {
                System.out.println ( "Unprocessed record" );
            }
        }

    }

    private void sortCustomer() {
        TreeMap<Integer, String> sorted = new TreeMap<Integer, String> ( mapCustomer );
        Set<Map.Entry<Integer, String>> mappings = sorted.entrySet ();
        System.out.println ( "Customer List within 100km after sorting by user_id in ascending order " );
        for (Entry<Integer, String> mapping : mappings) {
            System.out.println ( "User Id: " + mapping.getKey () + " Name: " + mapping.getValue () );
        }
    }

    private static void log(Object obj) {
        System.out.println ( Objects.toString ( obj ) );
    }

    @Test
    private boolean getDistance(String latitude, String longitude, double lat2, double long2) {
        double lat1 = Double.parseDouble ( latitude );
        double long1 = Double.parseDouble ( longitude );
        double deltaLat = Math.toRadians ( lat2 - lat1 );
        double deltaLong = Math.toRadians ( long2 - long1 );
        lat1 = Math.toRadians ( lat1 );
        lat2 = Math.toRadians ( lat2 );
        double ans = Math.pow ( Math.sin ( deltaLat / 2 ), 2 ) + Math.pow ( Math.sin ( deltaLong / 2 ), 2 ) * Math.cos ( lat1 ) * Math.cos ( lat2 );
        double c = 2 * Math.asin ( Math.sqrt ( ans ) );
        double distance = 6372.8 * c;

        return distance <= 100;
    }
}


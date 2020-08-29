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
    //getFile Name within the Constructor
public ParseTextFile(String filename) {
        filePath = get ( filename );
    }
    /*Reading the file line by line
    Check if the file has next line.
    Call the function parseContentInEachLine to read data in each line.
     */
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
                /*
                * Check if the latitude and longitude in the file are valid
                * Only for valid cordinates call the getDistance functions
                * */
                if(checkGeocordinates(latitude,longitude)){
                    if (getDistance ( latitude, longitude, 53.339428, -6.257664 )) {
                        mapCustomer.put ( Integer.parseInt ( user_id.trim ().substring ( 11 ) ), name.trim ().substring ( 9 ).replace("\"", "")) ;
                    }
                }

            } else {
                System.out.println ( "Unprocessed record" );
            }
        }

    }

    private boolean checkGeocordinates(String latitude, String longitude) {
        double lat1 = Double.parseDouble ( latitude );
        double long1 = Double.parseDouble ( longitude );
        if (lat1 < -90 || lat1 > 90) {
            System.out.println ("Invalid Latitude");
            return false;
        }
        if (long1 < -180 || long1 > 180) {
            System.out.println("Invalid Longitude");
            return false;
        }
        return true;
    }

    //sorting customer list within 100 km by key (user_id) in ascending order
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
        double a =((Math.sin(lat1))*(Math.sin(lat2)))+((Math.cos(lat1))*(Math.cos ( lat2 ))*(Math.cos(deltaLong)));
        double c =Math.acos ( a );
        double distance = 6371 * c;
        return distance <= 100;
    }
}


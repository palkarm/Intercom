import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;
import java.nio.file.Path;
import static java.nio.file.Paths.get;


public class ParseTextFile {
    private final Path filePath;
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String[] args) throws IOException {
        ParseTextFile parseTextFile = new ParseTextFile ( "CustomerList.txt" );
        parseTextFile.parseLineByLine ();

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
                String name = scanner.next();
                String longitude = scanner.next();
                latitude = latitude.replaceAll("[a-zA-Z:\"\\s]","").replaceAll("\\p{Ps}", "");
                longitude = longitude.replaceAll("[a-zA-Z:\"\\s]","").replaceAll("}$", "");
                if(getDistance(latitude,longitude, 53.339428, -6.257664)){
                    System.out.println(name.trim() + " "+  "; " + " "+user_id.trim());
                }

            }
            else {
                log("Empty or invalid line. Unable to process.");
            }
        }
    }

    private static void log(Object obj) {
        System.out.println( Objects.toString(obj));
    }
@Test
    private boolean getDistance(String latitude, String longitude, double lat2, double long2) {

        double lat1 = Double.parseDouble(latitude);
        double long1 = Double.parseDouble(longitude);
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLong = Math.toRadians(long2 - long1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        double a = Math.pow(Math.sin(deltaLat / 2),2) + Math.pow(Math.sin(deltaLong / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double distance =  6372.8 * c  ;
//        if(distance<=100)
//        {System.out.println ("Distance " + distance + " km");}
        return distance<=100;

    }

}


import org.junit.jupiter.api.Test;

import java.io.File;

class ParseTextFileTest {

    private Object ParseTextFile;

    @Test
    void setUp() {
        System.out.println ("Setup complete");
    }

    @Test
    void tearDown() {
        System.out.println ("test");
    }

    @Test
   void main() {
        File file = new File ( "/" );
        //Check if file exists at current directory
        File fileInput = new File("CustomerList.txt")   ;

        if (file.exists ())
            System.out.println ( "File found at the directory" );
            if(fileInput.length ()==0)
            System.out.println("File is empty");
            else
                System.out.println("File is not empty");
        checkGeocordinates("0","0");
    }

        /**
         * @return
         * @param
         */

        boolean checkGeocordinates (String Latitude, String Longitude){
            //Check if entered latitude and longitude are valid
            double lat1 = Double.parseDouble ( Latitude );
            double long1 = Double.parseDouble ( Longitude );
            if (lat1 < -90 || lat1 > 90) {
                System.out.println ("Invalid Latitude");
                return false;
            }
            if (long1 < -180 || long1 > 180) {
                System.out.println("Invalid Longitude");
                return false;
            }
            System.out.println("Valid Geo-Cordinates");
            return true;
        }

}



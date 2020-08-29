import org.junit.ClassRule;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

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
   void main(){
        File file = new File ( "/" );
        //Check if file exists at current directory
        if(file.exists ())
        System.out.println ("File found at the directory");
        }

    /**
     * @return
     */
    void  getDistance(){
        assertFalse ( null, "Invalid" );
        System.out.println ("Wrong result");
        }

}



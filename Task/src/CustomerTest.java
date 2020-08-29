import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void setUp() {
        Customer customer = new Customer ("", 40);
        assertNull ( customer ,"invalid" );
    }

    @AfterEach
    void tearDown() {
    }
}
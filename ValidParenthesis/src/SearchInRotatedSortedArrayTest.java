import org.jcp.xml.dsig.internal.dom.Utils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.jcp.xml.dsig.internal.dom.Utils.*;

public class SearchInRotatedSortedArrayTest extends SearchInRotatedSortedArray {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    public void main(){
        int nums[]={4,5,6,7,0,1,2};
        Assert.assertEquals ( "Wrong index", true, search ( nums, 0 ) != 4 );

    }
}

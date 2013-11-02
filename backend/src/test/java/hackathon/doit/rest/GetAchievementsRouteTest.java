package hackathon.doit.rest;

import hackathon.doit.BaseEbeanTest;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class GetAchievementsRouteTest extends BaseEbeanTest {

    public GetAchievementsRouteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        super.importData("testdata/achievements_route.sql");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of handle method, of class GetAchievementsRoute.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        Request request = Mockito.mock(Request.class);
        Response response = Mockito.mock(Response.class);

        GetAchievementsRoute instance = new GetAchievementsRoute("");
        Object expResult = null;
        Object result = instance.handle(request, response);

        assertTrue(result instanceof List);
        assertEquals(9, ((List) result).size());

    }

}

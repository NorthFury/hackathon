/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class GetActivitiesRouteTest extends BaseEbeanTest {

    public GetActivitiesRouteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of handle method, of class GetActivitiesRoute.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        Request request = Mockito.mock(Request.class);
        Response response = Mockito.mock(Response.class);
        GetActivitiesRoute instance = new GetActivitiesRoute("");
        Object result = instance.handle(request, response);

        assertTrue(result instanceof List);
    }

}

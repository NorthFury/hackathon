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
public class GetTasksRouteTest extends BaseEbeanTest {

    public GetTasksRouteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        importData("testdata/getTaks_route.sql");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of handle method, of class GetTasksRoute.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        Request request = Mockito.mock(Request.class);
        Response response = Mockito.mock(Response.class);

        Mockito.when(request.params(":userId")).thenReturn("1");

        GetTasksRoute instance = new GetTasksRoute("/account/:userId/tasks");

        Object result = instance.handle(request, response);

        assertTrue(result instanceof List);
    }

}

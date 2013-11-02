/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackathon.doit.rest;

import hackathon.doit.BaseEbeanTest;
import hackathon.doit.model.Task;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
@Ignore
public class GetTaskRouteTest extends BaseEbeanTest {

    public GetTaskRouteTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        super.importData("testdata/getTaks_route.sql");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of handle method, of class GetTaskRoute.
     */
    @Test
    public void testHandle() {
        System.out.println("handle");
        Request request = Mockito.mock(Request.class);
        Response response = Mockito.mock(Response.class);
        GetTaskRoute instance = new GetTaskRoute("/account/:userId/tasks/:taskId");

        Object result = instance.handle(request, response);

        assertTrue(result instanceof Task);
    }

}

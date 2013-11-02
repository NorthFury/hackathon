package hackathon.doit.rest;

import hackathon.doit.BaseEbeanTest;

import org.junit.Before;
import org.junit.Test;

public class LogoutRouteTest extends BaseEbeanTest {
	@Before
    public void setUp() throws Exception {
        super.importData("testdata/getTaks_route.sql");
    }
	
	@Test
	public void testLogoutRoute() {
//		Request mockRequest = Mockito.mock(Request.class);
//		Response mockResponse = Mockito.mock(Response.class);
//		Mockito.when(mockRequest.headers("token")).thenReturn("abc");
		
		
		
	}
	
}

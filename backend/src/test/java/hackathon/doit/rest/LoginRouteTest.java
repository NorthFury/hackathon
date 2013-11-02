package hackathon.doit.rest;

import hackathon.doit.BaseEbeanTest;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import spark.QueryParamsMap;
import spark.Request;
import spark.Response;

public class LoginRouteTest extends BaseEbeanTest {
	@Before
    public void setUp() throws Exception {
        super.importData("testdata/getTaks_route.sql");
    }
	
	@SuppressWarnings("deprecation")
	@Test
	public void testLoginRoute() {
		Request mockRequest = Mockito.mock(Request.class);
		Response mockResponse = Mockito.mock(Response.class);
		Mockito.when(mockRequest.queryString()).thenReturn("openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.mode=check_authentication&openid.op_endpoint=https%3A%2F%2Fwww.google.com%2Faccounts%2Fo8%2Fud&openid.response_nonce=2013-11-02T12%3A57%3A08ZoOg7gnHjt_GzUg&openid.return_to=http%3A%2F%2Fwww.gog.com%2Fauth&openid.assoc_handle=1.AMlYA9V7eN8gAr3qWKzu7H01w0XHZTz8DAPD2WFedl7gGWiMI5L0RUexbhX_kq58&openid.signed=op_endpoint%2Cclaimed_id%2Cidentity%2Creturn_to%2Cresponse_nonce%2Cassoc_handle%2Cns.ext1%2Cext1.mode%2Cext1.type.email%2Cext1.value.email&openid.sig=3QUQ8UxO8VZdkS4um6saJV3Fe8Q%3D&openid.identity=https%3A%2F%2Fwww.google.com%2Faccounts%2Fo8%2Fid%3Fid%3DAItOawmHiWymj0EbunFv6LhXGm1lavCpUrYanuo&openid.claimed_id=https%3A%2F%2Fwww.google.com%2Faccounts%2Fo8%2Fid%3Fid%3DAItOawmHiWymj0EbunFv6LhXGm1lavCpUrYanuo&openid.ns.ext1=http%3A%2F%2Fopenid.net%2Fsrv%2Fax%2F1.0&openid.ext1.mode=fetch_response&openid.ext1.type.email=http%3A%2F%2Faxschema.org%2Fcontact%2Femail&openid.ext1.value.email=robyter%40gmail.com");
		
		QueryParamsMap queryParamsMap = Mockito.mock(QueryParamsMap.class);
		
		Mockito.when(mockRequest.queryMap()).thenReturn(queryParamsMap);
		Mockito.when(queryParamsMap.get("openid.ext1.value.email")).thenReturn(queryParamsMap);
		Mockito.when(queryParamsMap.value()).thenReturn("ABCD");
		
		// "https://www.google.com/accounts/o8/ud?"
		
		LoginRoute loginRoute = new LoginRoute("");
		
		Object result = loginRoute.handle(mockRequest, mockResponse);
		
		Assert.assertTrue(result instanceof Map<?, ?>);
	}
}

package hackathon.doit.rest.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import spark.Filter;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class AuthenticaitonFilter extends Filter {

    private static final String OPEN_ID_TOKEN = "token";

    public AuthenticaitonFilter(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public void handle(Request request, Response response) {
        try {
            final String token = request.headers(OPEN_ID_TOKEN);

            HttpPost post = new HttpPost("google OpenID URI");
            final String openIdJsonBody = "";
            post.setEntity(new StringEntity(openIdJsonBody, "UTF-8"));
            post.addHeader("accept", "application/json");

            DefaultHttpClient client = new DefaultHttpClient();

            client.execute(post);
        } catch (IOException ex) {
            Logger.getLogger(AuthenticaitonFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package hackathon.doit.rest.util;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonResponseCreator {

    protected static final ObjectMapper mapper = new ObjectMapper();

    public static Object getJsonResponse(String callback, Object responseBody) {
        try {
            return callback + "(" + mapper.writeValueAsString(responseBody) + ")";
        } catch (IOException ex) {
            return "Serialization error";
        }
    }
}

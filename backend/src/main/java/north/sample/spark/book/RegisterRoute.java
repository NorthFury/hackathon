/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package north.sample.spark.book;

import north.sample.spark.JsonTransformer;
import spark.Request;
import spark.Response;

/**
 *
 * @author Dutza
 */
public class RegisterRoute extends JsonTransformer {

    public RegisterRoute(String path) {
        super(path);
    }

    public RegisterRoute(String path, String acceptType) {
        super(path, acceptType);
    }

    @Override
    public Object handle(Request request, Response response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

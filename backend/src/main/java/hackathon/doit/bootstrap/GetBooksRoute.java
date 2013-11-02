package hackathon.doit.bootstrap;

import hackathon.doit.model.Book;
import hackathon.doit.rest.JsonTransformer;

import com.avaje.ebean.Ebean;

import spark.Request;
import spark.Response;

public class GetBooksRoute extends JsonTransformer {

    public GetBooksRoute(String path) {
        super(path);
    }

    @Override
    public Object handle(Request request, Response response) {
        return Ebean.find(Book.class).findList();
    }
    
}

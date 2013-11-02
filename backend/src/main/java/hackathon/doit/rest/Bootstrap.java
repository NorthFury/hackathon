package hackathon.doit.rest;

import hackathon.doit.bootstrap.DeleteBookRoute;
import hackathon.doit.bootstrap.GetBookRoute;
import hackathon.doit.bootstrap.GetBooksRoute;
import hackathon.doit.bootstrap.PostBookRoute;
import hackathon.doit.bootstrap.PutBookRoute;
import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);

        Spark.get(new GetBooksRoute("/books"));
        Spark.get(new GetBookRoute("/books/:id"));
        Spark.post(new PostBookRoute("/books"));
        Spark.put(new PutBookRoute("/books/:id"));
        Spark.delete(new DeleteBookRoute("/books/:id"));
    }
}

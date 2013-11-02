package north.sample.spark;

import north.sample.spark.book.DeleteBookRoute;
import north.sample.spark.book.GetBooksRoute;
import north.sample.spark.book.GetBookRoute;
import north.sample.spark.book.PutBookRoute;
import north.sample.spark.book.PostBookRoute;
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

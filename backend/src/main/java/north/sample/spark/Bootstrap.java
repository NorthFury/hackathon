package north.sample.spark;

import north.sample.spark.book.LoginRoute;
import north.sample.spark.book.LogoutRoute;
import north.sample.spark.book.RegisterRoute;
import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);

        Spark.post(new RegisterRoute("/user/register"));
        Spark.post(new LoginRoute("/user/login"));
        Spark.get(new LogoutRoute("/user/logout"));
    }
}

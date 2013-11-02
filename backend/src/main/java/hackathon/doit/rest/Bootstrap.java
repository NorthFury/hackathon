package hackathon.doit.rest;

import hackathon.doit.rest.filters.AuthenticaitonFilter;
import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);

        Spark.before(new AuthenticaitonFilter("", "application/json"));

        Spark.post(new RegisterRoute("/user/register"));
        Spark.post(new LoginRoute("/user/login"));
        Spark.get(new LogoutRoute("/user/logout"));
    }
}

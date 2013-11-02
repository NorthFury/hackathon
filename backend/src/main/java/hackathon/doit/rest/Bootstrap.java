package hackathon.doit.rest;

import hackathon.doit.rest.filters.AuthenticaitonFilter;
import hackathon.doit.model.Account;

import com.avaje.ebean.Ebean;

import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);

        Ebean.find(Account.class).findList();
        
        Spark.before(new AuthenticaitonFilter("", "application/json"));

        Spark.post(new LoginRoute("/account/login"));
        Spark.get(new LogoutRoute("/account/logout"));
    }
}

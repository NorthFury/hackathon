package hackathon.doit.rest;

import hackathon.doit.model.Account;

import com.avaje.ebean.Ebean;

import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);
        Ebean.find(Account.class).findList();
        Spark.post(new RegisterRoute("/user/register"));
        Spark.post(new LoginRoute("/user/login"));
        Spark.get(new LogoutRoute("/user/logout"));
    }
}

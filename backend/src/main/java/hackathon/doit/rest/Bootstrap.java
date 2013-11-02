package hackathon.doit.rest;

import hackathon.doit.model.Account;

import com.avaje.ebean.Ebean;

import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);
        Ebean.find(Account.class).findList();
        
        //Login/Register routes
        Spark.post(new RegisterRoute("/account/register"));
        Spark.post(new LoginRoute("/account/login"));
        Spark.get(new LogoutRoute("/account/logout"));
        
        Spark.get(new GetAchievementsRoute("/achievements"));
        Spark.get(new GetActivitiesRoute("/activities"));

    
    }
}

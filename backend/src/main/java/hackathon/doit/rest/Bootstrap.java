package hackathon.doit.rest;

import hackathon.doit.rest.filters.AuthenticaitonFilter;
import spark.Spark;

public class Bootstrap {

    public static void main(String[] args) {
        Spark.setPort(8085);
        // Ebean.find(Account.class).findList();
        
        configFilters();

        Spark.post(new LoginRoute("/account/login"));
        Spark.get(new LogoutRoute("/account/logout"));

        Spark.get(new GetAchievementsRoute("/achievements"));
        Spark.get(new GetActivitiesRoute("/activities"));

        Spark.post(new PostTaskRoute("/account/:username/task"));
        Spark.put(new PutTaskRoute("/account/:username/task/:taskId"));
        Spark.get(new GetTasksRoute("/account/:username/tasks"));
        Spark.get(new GetTaskRoute("/account/:username/tasks/:taskId"));

    }

    private static void configFilters() {
        Spark.before(new AuthenticaitonFilter("/achievements"));
        Spark.before(new AuthenticaitonFilter("/activities"));
        Spark.before(new AuthenticaitonFilter("/account/:username/task"));
        Spark.before(new AuthenticaitonFilter("/account/:username/task/:taskId"));
        Spark.before(new AuthenticaitonFilter("/account/:username/tasks"));
        Spark.before(new AuthenticaitonFilter("/account/:username/tasks/:taskId"));
    }
}

package hackathon.doit.rest;

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

        Spark.post(new PostTaskRoute("/account/:username/postTask"));
        Spark.put(new PutTaskRoute("/account/:username/task/:taskId"));
        Spark.get(new GetTasksRoute("/account/:username/tasks"));
        Spark.get(new GetTaskRoute("/account/:username/tasks/:taskId"));
    
    }
}

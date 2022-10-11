package exercise;

import exercise.model.EmployeeModel;
import exercise.service.JsonInputService;
import exercise.utils.JsonExpander;
import exercise.utils.Logger;
import exercise.utils.TimedTasks;

public class Application {
    public Application(){};

    private final JsonInputService jsonInputService = new JsonInputService();

//    public Application(JsonInputService jsonInputService) {
//        this.jsonInputService = jsonInputService;
//    }


    public static void main( String... args) {
        System.out.println("Starting Application and Timer");
        TimedTasks.startTimer();
        Application app = new Application();
        app.service();
    }

    public void service () {
        EmployeeModel employeeModel = jsonInputService.parseJsonObjects();
        jsonInputService.runTasks(employeeModel);
    }
}

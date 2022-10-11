package exercise.service;

//start the jsonReading here and build out objects
//hydrate objects

import exercise.model.EmployeeModel;
import exercise.model.InventoryModel;
import exercise.utils.JsonExpander;
import exercise.utils.JsonReader;
import exercise.utils.Logger;
import exercise.utils.TimedTasks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JsonInputService {

    //private Logger logger = new Logger();
    //private final JsonExpander jsonExpander = new JsonExpander();


    public EmployeeModel parseJsonObjects() {
        JsonReader jsonReader = new JsonReader();
        return new EmployeeModel(JsonExpander.expandInventory(jsonReader.getJson("/data.json")));
    }

    public void runTasks(EmployeeModel employeeModel) {
        taskOne(employeeModel);
        taskTwo(employeeModel);
        taskThree(employeeModel);
        taskFour(employeeModel);
        taskFive(employeeModel);
    }

    private void taskOne(EmployeeModel employeeModel) {
        System.out.println("Task Number One : Output Name");
        TimedTasks.stopTimer();
        Logger.log("Name", employeeModel.getName(), TimedTasks.getDurationInMilliseconds());
        System.out.println("---------------------------------------");
    }

    private void taskTwo(EmployeeModel employeeModel) {
        System.out.println("Task Number Two : Output position and level");
        TimedTasks.stopTimer();
        Logger.log("Position and Level", employeeModel.getVitals().toString(), TimedTasks.getDurationInMilliseconds());
        System.out.println("---------------------------------------");

    }

    private void taskThree(EmployeeModel employeeModel) {
        System.out.println("Task Number Three : Output total number of item types");
        TimedTasks.stopTimer();
        Logger.log("Number of items", String.valueOf(employeeModel.getInventoryList().size()), TimedTasks.getDurationInMilliseconds());
        for (InventoryModel model : employeeModel.getInventoryList()) {
            System.out.println(model.toString());
        }
        System.out.println("---------------------------------------");
    }

    private void taskFour(EmployeeModel employeeModel) {
        System.out.println("Task Number Four : Output total number of (non-null) notes");
        TimedTasks.stopTimer();
        List<String> notesList = employeeModel.getInventoryList().stream().filter(x -> Objects.nonNull(x.getNotes())).map(InventoryModel::getNotes).collect(Collectors.toList());
        Logger.log("Number of notes", String.valueOf(notesList.size()), TimedTasks.getDurationInMilliseconds());
        System.out.println("---------------------------------------");
    }

    private void taskFive(EmployeeModel employeeModel) {
        System.out.println("Task Number Five : Ouput total number of items in stock");
        TimedTasks.stopTimer();
        Logger.log("In Stock Items", String.valueOf(employeeModel.getInStockTotal()), TimedTasks.getDurationInMilliseconds());
        System.out.println("---------------------------------------");

    }
}

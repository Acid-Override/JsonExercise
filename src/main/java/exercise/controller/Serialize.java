package exercise.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercise.model.EmployeeModel;

import java.io.File;
import java.io.IOException;

public class Serialize {

    public void serializeJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeModel employeeModel = objectMapper.readValue(new File("data.json"), EmployeeModel.class);



    }

}

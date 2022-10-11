package exercise.model;

import exercise.utils.JsonExpander;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeeModel {

    private String name;
    private List<InventoryModel> inventoryList = new ArrayList<>();
    private VitalsModel vitals;

    private Integer inStockTotal;

    public EmployeeModel(String name) {
        this.name = name;
    }

    public EmployeeModel(String name, List<InventoryModel> inventoryList, VitalsModel vitals) {
        this.name = name;
        this.inventoryList = inventoryList;
        this.vitals = vitals;
    }

    public EmployeeModel(JSONObject json) {
        name = json.getString("name");
        setInventory(json.getJSONArray("inventory"));
        setVitals(json.getJSONObject("vitals"));
        calculateInStockTotal();
    }

    private void calculateInStockTotal() {
        this.inStockTotal = inventoryList.stream().reduce(0, (subtotal, element) -> subtotal + element.getInStock(), Integer::sum);
    }

    private void setInventory(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++ ) {
            inventoryList.add(new InventoryModel(jsonArray.getJSONObject(i)));
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<InventoryModel> getInventoryList() {
        return inventoryList;
    }
    public void setInventoryList(List<InventoryModel> inventoryList) {
        this.inventoryList = inventoryList;
    }

    public VitalsModel getVitals() {
        return vitals;
    }
    public void setVitals(JSONObject vitals) {
        this.vitals = new VitalsModel(vitals);
    }

    public Integer getInStockTotal() {
        return inStockTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeModel that = (EmployeeModel) o;
        return Objects.equals(name, that.name) && Objects.equals(inventoryList, that.inventoryList) && Objects.equals(vitals, that.vitals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, inventoryList, vitals);
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "name='" + name + '\'' +
                ", inventoryList=" + inventoryList +
                ", vitals=" + vitals +
                '}';
    }


}

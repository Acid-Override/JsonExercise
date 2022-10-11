package exercise.model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

public class InventoryModel {

    private String itemType;
    private Integer inStock;
    private String notes;



    public InventoryModel(String itemType, Integer inStock, String notes) {
        this.itemType = itemType;
        this.inStock = inStock;
        this.notes = notes;
    }

    public InventoryModel(JSONObject item) {
        setItemType(item.getString("itemType"));
        setInStock(item.getInt("inStock"));
        if(item.has("notes") && !item.isNull("notes")) {
            setNotes(item.getString("notes"));
        }
    }


    public String getItemType() {
        return itemType;
    }
    public void setItemType(String itemType) {
        if (null != itemType)
            this.itemType = itemType;
    }

    public Integer getInStock() {
        return inStock;
    }
    public void setInStock(Integer inStock) {
        if (null != inStock)
            this.inStock = inStock;
    }

    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        if (null != notes)
            this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryModel that = (InventoryModel) o;
        return Objects.equals(itemType, that.itemType) && Objects.equals(inStock, that.inStock) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemType, inStock, notes);
    }

    @Override
    public String toString() {
        return "InventoryModel{" +
                "itemType='" + itemType + '\'' +
                ", inStock=" + inStock +
                ", notes='" + notes + '\'' +
                '}';
    }


}

package exercise.model;

import org.json.JSONObject;

import java.util.Objects;

public class VitalsModel {

    private String position;
    private String level;

    public VitalsModel(String position, String level) {
        this.position = position;
        this.level = level;
    }

    public VitalsModel() {}

    public VitalsModel(JSONObject vitals) {
        setPosition(vitals.getString("position"));
        setLevel(vitals.getString("level"));
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VitalsModel that = (VitalsModel) o;
        return Objects.equals(position, that.position) && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, level);
    }

    @Override
    public String toString() {
        return "VitalsModel{" +
                "position='" + position + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}

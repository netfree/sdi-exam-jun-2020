package ro.ubb.exam.common.model;

public class Sensor {
    private String name;
    private int id;
    private int measurement;

    @Override
    public String toString() {
        return "Sensor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", measurement=" + measurement +
                '}';
    }

    public Sensor(String name, int id, int measurement) {
        this.name = name;
        this.id = id;
        this.measurement = measurement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }
}

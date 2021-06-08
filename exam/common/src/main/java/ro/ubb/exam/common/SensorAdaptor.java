package ro.ubb.exam.common;

import ro.ubb.exam.common.model.Sensor;

public class SensorAdaptor {
    public static String sensorToMessage(Sensor sensor){
        return sensor.getName() + "," + sensor.getId() + "," +  sensor.getMeasurement();
    }

    public static Sensor messageToSensor(String message) {
        String[] tokens = message.split(",");
        return new Sensor(tokens[0], Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
    }
}

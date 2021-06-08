package ro.ubb.exam.client.ui;

import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.common.model.Sensor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.Future;

public class Console {

    private SensorService sensorService;
    String name;
    int id;
    int lower_bound;
    int upper_bound;

    public Console(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    public void run(){
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.print("name: ");
            name = bufferRead.readLine();
            System.out.print("id: ");
            id = Integer.parseInt(bufferRead.readLine());
            if(id < 1023)
                throw new Exception("id lower than 1023");
            System.out.print("lower_bound: ");
            lower_bound = Integer.parseInt(bufferRead.readLine());
            System.out.print("upper_bound: ");
            upper_bound = Integer.parseInt(bufferRead.readLine());
        } catch (Exception e) {
            System.out.println("error while initializing sensor");
        }

        while (true) {
            Future<Boolean> resultFuture = sensorService.addSensorData(new Sensor(name, id, new Random().nextInt(upper_bound-lower_bound) + lower_bound));
            try {
                Thread.sleep(new Random().nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

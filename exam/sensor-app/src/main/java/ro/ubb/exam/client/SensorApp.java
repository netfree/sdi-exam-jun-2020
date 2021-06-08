package ro.ubb.exam.client;

import ro.ubb.exam.client.service.SensorServiceClient;
import ro.ubb.exam.client.tcp.TcpClient;
import ro.ubb.exam.client.ui.Console;
import ro.ubb.exam.common.SensorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SensorApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        TcpClient tcpClient = new TcpClient(executorService);
        SensorService sensorService = new SensorServiceClient(executorService, tcpClient);
        Console console = new Console(sensorService);
        console.run();

        System.out.println("bye client");

        executorService.shutdown();
    }
}

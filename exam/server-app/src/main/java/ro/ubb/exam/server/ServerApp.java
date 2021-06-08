package ro.ubb.exam.server;

import ro.ubb.exam.common.Message;
import ro.ubb.exam.common.SensorAdaptor;
import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.server.service.SensorServiceImpl;
import ro.ubb.exam.server.tcp.TcpServer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ServerApp {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors()
        );

        TcpServer tcpServer = new TcpServer(executorService, SensorService.PORT);
        SensorService sensorService = new SensorServiceImpl(executorService);

        tcpServer.addHandler("addSensorData", request -> {
            Future<Boolean> res = sensorService.addSensorData(SensorAdaptor.messageToSensor(request.getBody()));
            try {
                Boolean result = res.get();
                Message response = new Message(Message.OK, result.toString());
                return response;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return new Message(Message.ERROR, e.getMessage());
            }
        });

        tcpServer.startServer();

        System.out.println("bye server");
    }
}

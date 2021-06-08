package ro.ubb.exam.client.service;

import ro.ubb.exam.client.tcp.TcpClient;
import ro.ubb.exam.common.Message;
import ro.ubb.exam.common.SensorAdaptor;
import ro.ubb.exam.common.SensorService;
import ro.ubb.exam.common.model.Sensor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class SensorServiceClient implements SensorService {

    private ExecutorService executorService;
    private TcpClient tcpClient;

    public SensorServiceClient(ExecutorService executorService, TcpClient tcpClient) {
        this.executorService = executorService;
        this.tcpClient = tcpClient;
    }


    @Override
    public Future<Boolean> addSensorData(Sensor sensor) {

        return executorService.submit(
                () -> {
                    Message request = new Message("addSensorData", SensorAdaptor.sensorToMessage(sensor));
                    Message response = tcpClient.sendAndReceive(request);
                    String result = response.getBody();
                    return Boolean.getBoolean(result);
                }
        );

    }
}
